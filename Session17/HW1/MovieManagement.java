import java.sql.*;

public class MovieManagement {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/moviedb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addMovie(String title, String director, int year) throws SQLException {
        try (Connection conn = getConnection();
            CallableStatement stmt = conn.prepareCall("call add_movie(?, ?, ?)")) {
            stmt.setString(1, title);
            stmt.setString(2, director);
            stmt.setInt(3, year);
            stmt.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listMovies() throws SQLException {
        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM list_movies()")) {
            System.out.println("\n--- DANH SÁCH PHIM ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %-20s | Đạo diễn: %-15s | Năm: %d\n",
                        rs.getInt("id"), rs.getString("title"),
                        rs.getString("director"), rs.getInt("year"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMovie(int id, String title, String director, int year) throws SQLException {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("call update_movie(?, ?, ?, ?)")) {
             stmt.setInt(1, id);
             stmt.setString(2, title);
             stmt.setString(3, director);
             stmt.setInt(4, year);
             stmt.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteMovie(int id) throws SQLException {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("call delete_movie(?)")) {
            stmt.setInt(1, id);
            stmt.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
