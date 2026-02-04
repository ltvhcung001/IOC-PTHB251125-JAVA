import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int currentId = 1;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n============== MENU ==============");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại sinh viên theo GPA");
            System.out.println("0. Thoát chương trình");
            System.out.println("==================================");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    classifyStudents();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    // Chức năng 1: Nhập danh sách
    private static void addStudents() {
        System.out.print("Nhập số lượng sinh viên muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sinh viên thứ " + (i + 1) + ":");
            System.out.print("- Họ tên: ");
            String name = sc.nextLine();
            System.out.print("- Điểm GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            studentList.add(new Student(currentId++, name, gpa));
        }
        System.out.println("Thêm thành công!");
    }

    private static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    private static void searchByName() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String searchName = sc.nextLine();
        boolean found = false;
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sinh viên nào có tên: " + searchName);
    }

    private static void classifyStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("\n--- KẾT QUẢ PHÂN LOẠI GPA ---");
        for (Student s : studentList) {
            System.out.println("Sinh viên: " + s.getName() + " | GPA: " + s.getGpa() + " -> Xếp loại: " + s.getRank());
        }
    }
}