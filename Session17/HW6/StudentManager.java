import java.sql.*;

public class StudentManager {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/school_db";
        String user = "postgres"; 
        String pass = "123456";  
        return DriverManager.getConnection(url, user, pass);
    }

    public void addStudent(Student student) {
        try (Connection conn = getConnection()) {
            String checkSql = "SELECT id FROM Student WHERE email = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkSql);
            psCheck.setString(1, student.getEmail());
            if (psCheck.executeQuery().next()) {
                System.out.println("Lỗi: Email này đã tồn tại!");
                return;
            }

            String sql = "INSERT INTO Student (name, email) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.executeUpdate();
            System.out.println("Thêm sinh viên thành công.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void addCourse(Course course) {
        try (Connection conn = getConnection()) {
            String checkSql = "SELECT id FROM Course WHERE title = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkSql);
            psCheck.setString(1, course.getTitle());
            if (psCheck.executeQuery().next()) {
                System.out.println("Lỗi: Khóa học này đã tồn tại!");
                return;
            }

            String sql = "INSERT INTO Course (title, credits) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course.getTitle());
            ps.setInt(2, course.getCredits());
            ps.executeUpdate();
            System.out.println("Thêm khóa học thành công.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void enrollStudent(int studentId, int courseId) {
        try (Connection conn = getConnection()) {
            if (!exists("Student", studentId) || !exists("Course", courseId)) {
                System.out.println("Lỗi: ID sinh viên hoặc khóa học không hợp lệ.");
                return;
            }
            String sql = "INSERT INTO Enrollment (student_id, course_id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
            System.out.println("Ghi danh thành công.");
        } catch (SQLException e) { 
            System.out.println("Lỗi: Sinh viên đã ghi danh khóa học này trước đó.");
        }
    }

    public void listStudentsAndGrades() {
        String sql = "SELECT s.name, c.title, e.grade " +
                     "FROM Student s " +
                     "JOIN Enrollment e ON s.id = e.student_id " +
                     "JOIN Course c ON e.course_id = c.id";
        try (Connection conn = getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\n--- Kết quả học tập ---");
            while (rs.next()) {
                String grade = rs.getObject("grade") != null ? rs.getString("grade") : "Chưa có điểm";
                System.out.printf("SV: %s | Khóa học: %s | Điểm: %s\n", 
                        rs.getString("name"), rs.getString("title"), grade);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateStudentGrade(int studentId, int courseId, double grade) {
        String sql = "UPDATE Enrollment SET grade = ? WHERE student_id = ? AND course_id = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, grade);
            ps.setInt(2, studentId);
            ps.setInt(3, courseId);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Cập nhật điểm thành công.");
            else System.out.println("Lỗi: Không tìm thấy thông tin ghi danh.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private boolean exists(String table, int id) throws SQLException {
        try (Connection conn = getConnection()) {
            String sql = "SELECT id FROM " + table + " WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeQuery().next();
        }
    }
}