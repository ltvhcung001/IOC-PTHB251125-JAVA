import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int currentId = 1;

    public static void main(String[] args) {
        InvoiceManager manager = new InvoiceManager();
        int choice;

        do {
            System.out.println("\n**************** MENU QUẢN LÝ HÓA ĐƠN ****************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    String code = inputCode();
                    double amount = inputAmount();
                    manager.add(new Invoice(currentId++, code, amount));
                    System.out.println("Hóa đơn đã được thêm thành công.");
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần sửa: ");
                    int editId = Integer.parseInt(sc.nextLine());
                    int editIndex = manager.findIndexById(editId);
                    if (editIndex != -1) {
                        String newCode = inputCode();
                        double newAmount = inputAmount();
                        manager.update(editIndex, new Invoice(editId, newCode, newAmount));
                        System.out.println("Hóa đơn đã được sửa thành công.");
                    } else {
                        System.out.println("Không tìm thấy hóa đơn có id = " + editId);
                    }
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần xóa: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    int delIndex = manager.findIndexById(delId);
                    if (delIndex != -1) {
                        manager.delete(delIndex);
                        System.out.println("Hóa đơn đã được xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy hóa đơn có id = " + delId);
                    }
                    break;

                case 4:
                    manager.display();
                    break;
            }
        } while (choice != 5);
    }

    private static String inputCode() {
        while (true) {
            System.out.print("Nhập mã hóa đơn: ");
            String code = sc.nextLine();
            if (code.trim().isEmpty()) {
                System.out.println("Vui lòng không để trống!");
            } else {
                return code;
            }
        }
    }

    private static double inputAmount() {
        while (true) {
            System.out.print("Nhập số tiền: ");
            try {
                double amount = Double.parseDouble(sc.nextLine());
                if (amount < 0) {
                    System.out.println("Vui lòng nhập số thực >= 0!");
                } else {
                    return amount;
                }
            } catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ, vui lòng nhập số!");
            }
        }
    }
}