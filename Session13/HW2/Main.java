import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n**************** MENU QUẢN LÝ ĐIỂM DANH ****************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID sinh viên: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên sinh viên: ");
                    String name = sc.nextLine();
                    manager.add(new Student(id, name));
                    System.out.println("Sinh viên đã được thêm thành công.");
                    break;
                case 2:
                    manager.display();
                    System.out.print("Nhập ID sinh viên cần sửa: ");
                    int editId = Integer.parseInt(sc.nextLine());
                    int editIndex = manager.findIndexById(editId);
                    if (editIndex != -1) {
                        System.out.print("Nhập tên mới sinh viên: ");
                        String newName = sc.nextLine();
                        manager.update(editIndex, new Student(editId, newName));
                        System.out.println("Sinh viên đã được sửa thành công.");
                    } else {
                        System.out.println("Không tìm thấy sinh viên có ID này.");
                    }
                    break;
                case 3:
                    manager.display();
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    int deleteIndex = manager.findIndexById(deleteId);
                    if (deleteIndex != -1) {
                        manager.delete(deleteIndex);
                        System.out.println("Đã xóa thành công sinh viên!");
                    } else {
                        System.out.println("Không tìm thấy sinh viên có ID này.");
                    }
                    break;
                case 4:
                    manager.display();
                    break;
                case 5:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }
}