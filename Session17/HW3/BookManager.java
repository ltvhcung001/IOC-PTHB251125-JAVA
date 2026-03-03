import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private String url = "jdbc:postgresql://localhost:5432/library_db";
    private String user = "postgres";
    private String password = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private boolean isIdExists(int id) throws SQLException {
        String sql = "SELECT id FROM books WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public void addBook(Book book) throws SQLException {
        String checkSql = "SELECT id FROM books WHERE title = ? AND author = ?";
        try (Connection conn = getConnection()) {
            try (PreparedStatement pstmt = conn.prepareStatement(checkSql)) {
                pstmt.setString(1, book.getTitle());
                pstmt.setString(2, book.getAuthor());
                if (pstmt.executeQuery().next()) {
                    System.out.println("Lỗi: Sách này đã tồn tại trong thư viện!");
                    return;
                }
            }
            String insertSql = "INSERT INTO books (title, author, published_year, price) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setString(1, book.getTitle());
                pstmt.setString(2, book.getAuthor());
                pstmt.setInt(3, book.getPublishedYear());
                pstmt.setDouble(4, book.getPrice());
                pstmt.executeUpdate();
                System.out.println("Thêm sách thành công!");
            }
        }
    }

    public void updateBook(int id, Book book) throws SQLException {
        if (!isIdExists(id)) {
            System.out.println("Lỗi: Không tìm thấy sách với ID = " + id);
            return;
        }
        String sql = "UPDATE books SET title=?, author=?, published_year=?, price=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPublishedYear());
            pstmt.setDouble(4, book.getPrice());
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            System.out.println("Cập nhật thành công!");
        }
    }

    public void deleteBook(int id) throws SQLException {
        if (!isIdExists(id)) {
            System.out.println("Lỗi: Không tìm thấy sách để xóa!");
            return;
        }
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Xóa sách thành công!");
        }
    }

    public void findBooksByAuthor(String author) throws SQLException {
        String sql = "SELECT * FROM books WHERE author LIKE ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + author + "%");
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(rowToBook(rs));
            }
            if (!found) System.out.println("Không tìm thấy sách của tác giả này.");
        }
    }

    public void listAllBooks() throws SQLException {
        String sql = "SELECT * FROM books";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rowToBook(rs));
            }
        }
    }

    private Book rowToBook(ResultSet rs) throws SQLException {
        Book b = new Book(rs.getString("title"), rs.getString("author"), rs.getInt("published_year"), rs.getDouble("price"));
        b.setId(rs.getInt("id"));
        return b;
    }
}