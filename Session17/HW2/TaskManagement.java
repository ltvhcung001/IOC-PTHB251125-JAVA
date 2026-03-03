import java.sql.*;

public class TaskManagement {
    private String url = "jdbc:postgresql://localhost:5432/todolistdb";
    private String user = "postgres";
    private String password = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addTask(String name, String status) throws SQLException {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("call add_task(?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, status);
            stmt.execute();
        }
    }

    public void listTasks() throws SQLException {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM list_tasks()")) {
            System.out.println("\n--- DANH SÁCH CÔNG VIỆC ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %-25s | Trạng thái: %s\n",
                        rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
            }
        }
    }

    public void updateTaskStatus(int id, String status) throws SQLException {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("call update_task_status(?, ?)")) {
            stmt.setInt(1, id);
            stmt.setString(2, status);
            stmt.execute();
        }
    }

    public void deleteTask(int id) throws SQLException {
        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall("call delete_task(?)")) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    public void searchTaskByName(String name) throws SQLException {
        String sql = "SELECT * FROM search_task_by_name(?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %-25s | Trạng thái: %s\n",
                        rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
            }
        }
    }

    public void taskStatistics() throws SQLException {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM task_statistics()")) {
            System.out.println("\n--- THỐNG KÊ CÔNG VIỆC ---");
            while (rs.next()) {
                System.out.println(rs.getString("status") + ": " + rs.getLong("total"));
            }
        }
    }
}