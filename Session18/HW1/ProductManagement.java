import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/ProductManagement";
        return DriverManager.getConnection(url, "postgres", "123456");
    }

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM get_all_products()")) {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getDate(5), rs.getString(6), rs.getBoolean(7)));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void addProduct(Product p) {
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);
            try (CallableStatement cstmt = conn.prepareCall("{call add_product(?,?,?,?,?,?)}")) {
                cstmt.setString(1, p.getName());
                cstmt.setFloat(2, p.getPrice());
                cstmt.setString(3, p.getTitle());
                cstmt.setDate(4, p.getCreated());
                cstmt.setString(5, p.getCatalog());
                cstmt.setObject(6, p.isStatus() ? "1" : "0", Types.BIT);
                cstmt.execute();
                conn.commit(); 
                System.out.println("Thêm thành công!");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Lỗi: " + e.getMessage());
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateProduct(Product p) {
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false); 
            try (CallableStatement cstmt = conn.prepareCall("{call update_product(?,?,?,?,?,?)}")) {
                cstmt.setInt(1, p.getId());
                cstmt.setString(2, p.getName());
                cstmt.setFloat(3, p.getPrice());
                cstmt.setString(4, p.getTitle());
                cstmt.setString(5, p.getCatalog());
                cstmt.setObject(6, p.isStatus() ? "1" : "0", Types.BIT);
                
                int rows = cstmt.executeUpdate();
                conn.commit(); 
                System.out.println("Cập nhật thành công!");
            } catch (SQLException e) {
                conn.rollback(); 
                System.out.println("Lỗi cập nhật: " + e.getMessage());
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deleteProduct(int id) {
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);
            try (CallableStatement cstmt = conn.prepareCall("{call delete_product(?)}")) {
                cstmt.setInt(1, id);
                cstmt.execute();
                conn.commit();
                System.out.println("Xóa sản phẩm thành công!");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Lỗi xóa: " + e.getMessage());
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Product> getAllSortedByPrice() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product ORDER BY Product_Price ASC";
        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getDate(5), rs.getString(6), rs.getBoolean(7)));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void searchByName(String name) {
        String sql = "SELECT * FROM Product WHERE Product_Name ILIKE ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %s | Giá: %.2f\n", rs.getInt(1), rs.getString(2), rs.getFloat(3));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void countByCatalog() {
        String sql = "SELECT Product_catalog, COUNT(*) FROM Product GROUP BY Product_catalog";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Danh mục: " + rs.getString(1) + " - Số lượng: " + rs.getInt(2));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}