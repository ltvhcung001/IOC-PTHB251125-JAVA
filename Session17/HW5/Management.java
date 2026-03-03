import java.sql.*;

public class Management {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/management_db";
        String user = "postgres";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }

    public void addEmployee(Employee emp) {
        String checkSql = "SELECT COUNT(*) FROM Employee WHERE name = ?";
        String insertSql = "INSERT INTO Employee (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = getConnection()) {
            PreparedStatement pstmtCheck = conn.prepareStatement(checkSql);
            pstmtCheck.setString(1, emp.getName());
            ResultSet rs = pstmtCheck.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Lỗi: Tên nhân viên đã tồn tại!");
                return;
            }

            PreparedStatement pstmtInsert = conn.prepareStatement(insertSql);
            pstmtInsert.setString(1, emp.getName());
            pstmtInsert.setString(2, emp.getDepartment());
            pstmtInsert.setDouble(3, emp.getSalary());
            pstmtInsert.executeUpdate();
            System.out.println("Thêm nhân viên thành công.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void addProject(Project proj) {
        String checkSql = "SELECT COUNT(*) FROM Project WHERE name = ?";
        String insertSql = "INSERT INTO Project (name, budget) VALUES (?, ?)";
        try (Connection conn = getConnection()) {
            PreparedStatement pstmtCheck = conn.prepareStatement(checkSql);
            pstmtCheck.setString(1, proj.getName());
            ResultSet rs = pstmtCheck.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Lỗi: Tên dự án đã tồn tại!");
                return;
            }

            PreparedStatement pstmtInsert = conn.prepareStatement(insertSql);
            pstmtInsert.setString(1, proj.getName());
            pstmtInsert.setDouble(2, proj.getBudget());
            pstmtInsert.executeUpdate();
            System.out.println("Thêm dự án thành công.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void assignEmployeeToProject(int empId, int projId, String role) {
        try (Connection conn = getConnection()) {
            if (!exists("Employee", empId) || !exists("Project", projId)) {
                System.out.println("Lỗi: Nhân viên hoặc Dự án không tồn tại.");
                return;
            }
            String sql = "INSERT INTO Assignment (employee_id, project_id, role) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, empId);
            pstmt.setInt(2, projId);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
            System.out.println("Gán nhân viên vào dự án thành công.");
        } catch (SQLException e) { System.out.println("Lỗi: Có thể nhân viên đã có trong dự án này."); }
    }


    public void listEmployeesAndProjects() {
        String sql = "SELECT e.name as emp_name, p.name as proj_name, a.role " +
                "FROM Employee e " +
                "JOIN Assignment a ON e.id = a.employee_id " +
                "JOIN Project p ON a.project_id = p.id";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Danh sách phân công ---");
            while (rs.next()) {
                System.out.printf("NV: %s | Dự án: %s | Vai trò: %s\n",
                        rs.getString("emp_name"), rs.getString("proj_name"), rs.getString("role"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateEmployeeSalary(int empId, double newSalary) {
        try (Connection conn = getConnection()) {
            if (!exists("Employee", empId)) {
                System.out.println("Lỗi: Nhân viên không tồn tại.");
                return;
            }
            String sql = "UPDATE Employee SET salary = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, newSalary);
            pstmt.setInt(2, empId);
            pstmt.executeUpdate();
            System.out.println("Cập nhật lương thành công.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private boolean exists(String table, int id) throws SQLException {
        try (Connection conn = getConnection()) {
            String sql = "SELECT COUNT(*) FROM " + table + " WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }
}