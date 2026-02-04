import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        int choice;

        do {
            System.out.println("\n**************** MENU QUẢN LÝ ĐƠN HÀNG ****************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    String code = inputWithValidation("Nhập mã đơn hàng: ");
                    String name = inputWithValidation("Nhập tên khách hàng: ");
                    manager.add(new Order(code, name));
                    System.out.println("Đơn hàng đã được thêm thành công.");
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập mã đơn hàng cần sửa: ");
                    String editCode = sc.nextLine();
                    int editIndex = manager.findIndexByCode(editCode);
                    if (editIndex != -1) {
                        String newName = inputWithValidation("Nhập tên khách hàng mới: ");
                        manager.update(editIndex, new Order(editCode, newName));
                        System.out.println("Đơn hàng đã được sửa thành công.");
                    } else {
                        System.out.println("Không tìm thấy đơn hàng mã: " + editCode);
                    }
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập mã đơn hàng cần xóa: ");
                    String delCode = sc.nextLine();
                    int delIndex = manager.findIndexByCode(delCode);
                    if (delIndex != -1) {
                        manager.delete(delIndex);
                        System.out.println("Đơn hàng đã được xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy đơn hàng mã: " + delCode);
                    }
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    // Hàm kiểm tra nhập liệu không được để trống
    private static String inputWithValidation(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("\nVui lòng không để trống !");
            } else {
                return input;
            }
        }
    }
}