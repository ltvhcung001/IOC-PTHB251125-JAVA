import java.util.Scanner;

public class Main {
    private static TaskManagement manager = new TaskManagement();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU TO-DO LIST =========");
            System.out.println("1. Thêm công việc");
            System.out.println("2. Liệt kê công việc");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("4. Xóa công việc");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addAction(); break;
                    case 2: manager.listTasks(); break;
                    case 3: updateAction(); break;
                    case 4: deleteAction(); break;
                    case 5: searchAction(); break;
                    case 6: manager.taskStatistics(); break;
                    case 0: return;
                    default: System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            } catch (Exception e) {
                System.out.println("Lỗi hệ thống: " + e.getMessage());
            }
        }
    }

    private static void addAction() throws Exception {
        System.out.print("Tên công việc: "); String name = sc.nextLine();
        System.out.print("Trạng thái (1: Chưa hoàn thành, 2: Đã hoàn thành): ");
        String status = sc.nextLine().equals("2") ? "đã hoàn thành" : "chưa hoàn thành";

        if (name.trim().isEmpty()) throw new Exception("Tên công việc không được để trống!");
        manager.addTask(name, status);
        System.out.println("Đã thêm thành công!");
    }

    private static void updateAction() throws Exception {
        System.out.print("Nhập ID cần cập nhật: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("Trạng thái mới (1: Chưa hoàn thành, 2: Đã hoàn thành): ");
        String status = sc.nextLine().equals("2") ? "đã hoàn thành" : "chưa hoàn thành";
        manager.updateTaskStatus(id, status);
        System.out.println("Cập nhật thành công!");
    }

    private static void deleteAction() throws Exception {
        System.out.print("Nhập ID cần xóa: "); int id = Integer.parseInt(sc.nextLine());
        manager.deleteTask(id);
        System.out.println("Đã xóa công việc.");
    }

    private static void searchAction() throws Exception {
        System.out.print("Nhập tên cần tìm: "); String name = sc.nextLine();
        manager.searchTaskByName(name);
    }
}