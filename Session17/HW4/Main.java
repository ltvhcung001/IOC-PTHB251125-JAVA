import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ ĐƠN HÀNG ===");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Cập nhật thông tin khách hàng");
            System.out.println("3. Tạo đơn hàng mới");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Tìm kiếm đơn hàng theo khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: // Thêm sản phẩm
                        System.out.print("Nhập tên sản phẩm: ");
                        String pName = sc.nextLine();
                        System.out.print("Nhập giá sản phẩm: ");
                        double pPrice = Double.parseDouble(sc.nextLine());

                        manager.addProduct(new Product(0, pName, pPrice));
                        break;

                    case 2: // CẬP NHẬT KHÁCH HÀNG (Case bạn đang thiếu)
                        System.out.print("Nhập ID khách hàng cần sửa: ");
                        int updateId = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập tên khách hàng mới: ");
                        String cName = sc.nextLine();
                        System.out.print("Nhập email mới: ");
                        String cEmail = sc.nextLine();

                        Customer updatedCustomer = new Customer(0, cName, cEmail);
                        manager.updateCustomer(updateId, updatedCustomer);
                        break;

                    case 3: // Tạo đơn hàng
                        System.out.print("Nhập ID Khách hàng: ");
                        int cid = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập ID Sản phẩm: ");
                        int pid = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập số lượng: ");
                        int qty = Integer.parseInt(sc.nextLine());

                        manager.createOrder(cid, pid, qty);
                        break;

                    case 4: // Hiển thị tất cả đơn hàng
                        manager.listAllOrders();
                        break;

                    case 5: // Tìm đơn hàng theo khách hàng
                        System.out.print("Nhập ID khách hàng để tìm đơn: ");
                        int searchCid = Integer.parseInt(sc.nextLine());
                        manager.getOrdersByCustomer(searchCid);
                        break;

                    case 6:
                        System.out.print("Nhập tên khách hàng: ");
                        String name = sc.nextLine();
                        System.out.print("Nhập email khách hàng: ");
                        String email = sc.nextLine();

                        if (name.trim().isEmpty() || email.trim().isEmpty()) {
                            System.out.println("Lỗi: Tên và Email không được để trống!");
                        } else {
                            Customer newCustomer = new Customer(0, name, email);
                            manager.addCustomer(newCustomer);
                        }
                        break;


                    case 0:
                        System.out.println("Đã thoát chương trình.");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
}