import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- QUẢN LÝ ĐÀO TẠO ---");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Thêm khóa học");
            System.out.println("3. Ghi danh sinh viên");
            System.out.println("4. Xem danh sách & điểm");
            System.out.println("5. Cập nhật điểm");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Tên SV: "); String name = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    manager.addStudent(new Student(0, name, email));
                    break;
                case 2:
                    System.out.print("Tiêu đề khóa học: "); String title = sc.nextLine();
                    System.out.print("Số tín chỉ: "); int credits = sc.nextInt();
                    manager.addCourse(new Course(0, title, credits));
                    break;
                case 3:
                    System.out.print("ID Sinh viên: "); int sid = sc.nextInt();
                    System.out.print("ID Khóa học: "); int cid = sc.nextInt();
                    manager.enrollStudent(sid, cid);
                    break;
                case 4:
                    manager.listStudentsAndGrades();
                    break;
                case 5:
                    System.out.print("ID SV: "); int usid = sc.nextInt();
                    System.out.print("ID Khóa học: "); int ucid = sc.nextInt();
                    System.out.print("Điểm mới: "); double grade = sc.nextDouble();
                    manager.updateStudentGrade(usid, ucid, grade);
                    break;
                case 0:
                    return;
            }
        }
    }
}