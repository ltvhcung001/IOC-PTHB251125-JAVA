import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private String url = "jdbc:postgresql://localhost:5432/sales_management";
    private String user = "postgres";
    private String password = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addProduct(Product p) throws SQLException {
        String checkSql = "SELECT count(*) FROM Product WHERE name = ?";
        String insertSql = "INSERT INTO Product (name, price) VALUES (?, ?)";

        try (Connection conn = getConnection()) {
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, p.getName());
            ResultSet rs = checkPs.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("Lỗi: Tên sản phẩm đã tồn tại!");
                return;
            }

            PreparedStatement insertPs = conn.prepareStatement(insertSql);
            insertPs.setString(1, p.getName());
            insertPs.setDouble(2, p.getPrice());
            insertPs.executeUpdate();
            System.out.println("Thêm sản phẩm thành công.");
        }
    }

    public void updateCustomer(int id, Customer c) throws SQLException {
        String sql = "UPDATE Customer SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows == 0) System.out.println("Lỗi: Không tìm thấy khách hàng ID: " + id);
            else System.out.println("Cập nhật thành công.");
        }
    }

    public void createOrder(int customerId, int productId, int quantity) throws SQLException {
        String getPriceSql = "SELECT price FROM Product WHERE id = ?";
        String insertOrderSql = "INSERT INTO Orders (customer_id, order_date, total_amount) VALUES (?, CURDATE(), ?)";

        try (Connection conn = getConnection()) {
            PreparedStatement psPrice = conn.prepareStatement(getPriceSql);
            psPrice.setInt(1, productId);
            ResultSet rs = psPrice.executeQuery();

            if (rs.next()) {
                double price = rs.getDouble("price");
                double total = price * quantity;

                PreparedStatement psOrder = conn.prepareStatement(insertOrderSql);
                psOrder.setInt(1, customerId);
                psOrder.setDouble(2, total);
                psOrder.executeUpdate();
                System.out.println("Tạo đơn hàng thành công. Tổng tiền: " + total);
            } else {
                System.out.println("Lỗi: Không tìm thấy sản phẩm!");
            }
        }
    }

    public void listAllOrders() throws SQLException {
        String sql = "SELECT o.id, c.name, o.order_date, o.total_amount " +
                "FROM Orders o JOIN Customer c ON o.customer_id = c.id";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- DANH SÁCH ĐƠN HÀNG ---");
            while (rs.next()) {
                System.out.printf("Mã ĐH: %d | Khách: %-15s | Ngày: %s | Tổng: %.2f\n",
                        rs.getInt("id"), rs.getString("name"), rs.getDate("order_date"), rs.getDouble("total_amount"));
            }
        }
    }

    public void getOrdersByCustomer(int customerId) throws SQLException {
        String sql = "SELECT id, order_date, total_amount FROM Orders WHERE customer_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- ĐƠN HÀNG CỦA KHÁCH HÀNG ID: " + customerId + " ---");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("Mã ĐH: %d | Ngày đặt: %s | Tổng tiền: %.2f\n",
                        rs.getInt("id"), rs.getDate("order_date"), rs.getDouble("total_amount"));
            }
            if (!found) System.out.println("Khách hàng này chưa có đơn hàng nào.");
        }
    }

    public void addCustomer(Customer c) throws SQLException {
        String sql = "INSERT INTO Customer (name, email) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.executeUpdate();
            System.out.println("Thêm khách hàng thành công!");
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Lỗi: Email '" + c.getEmail() + "' đã tồn tại trong hệ thống!");
            } else {
                throw e;
            }
        }
    }
}