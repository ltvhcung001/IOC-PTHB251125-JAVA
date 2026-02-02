import ra.business.OrderBusiness;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderBusiness business = new OrderBusiness();

        while (true) {
            System.out.println("\n******************** QUẢN LÝ ĐƠN HÀNG ********************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Hiển thị danh sách đơn hàng (Giá giảm dần)");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4. Xóa đơn hàng");
            System.out.println("5. Tìm kiếm đơn hàng theo tên khách hàng");
            System.out.println("6. Thống kê tổng số đơn hàng");
            System.out.println("7. Thống kê doanh thu (Delivered)");
            System.out.println("8. Thống kê số lượng theo trạng thái");
            System.out.println("9. Tìm đơn hàng có giá trị lớn nhất");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        business.addOrder(scanner);
                        break;
                    case 2:
                        business.displayOrdersSortedByAmount();
                        break;
                    case 3:
                        business.updateOrderStatus(scanner);
                        break;
                    case 4:
                        business.deleteOrder(scanner);
                        break;
                    case 5:
                        business.searchByCustomerName(scanner);
                        break;
                    case 6:
                        // Thực hiện yêu cầu 6
                        business.countTotalOrders();
                        break;
                    case 7:
                        // Thực hiện yêu cầu 7
                        business.sumRevenueDelivered();
                        break;
                    case 8:
                        // Thực hiện yêu cầu 8
                        business.countOrdersByStatus();
                        break;
                    case 9:
                        business.findMaxAmountOrder();
                        break;
                    case 0:
                        System.out.println("Cảm ơn bạn đã sử dụng phần mềm. Tạm biệt!");
                        System.exit(0);
                    default:
                        System.err.println("Lựa chọn không hợp lệ (0-9).");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập vào một số nguyên!");
            }
        }
    }
}