import java.text.DecimalFormat;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Nhập tên khách hàng: ");
        String user_name = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String book_name = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = sc.nextDouble();
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = sc.nextInt();
        System.out.print("Khách có thẻ thành viên? (true/false): ");
        boolean isHaveCard = sc.nextBoolean();
        sc.close();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("==================== HÓA ĐƠN ====================");
        System.out.printf("Khách hàng : %s\n", user_name);
        System.out.printf("Sản phẩm   : %s\n", book_name);
        System.out.printf("Số lượng   : %d\n", quantity);
        System.out.println("Đơn giá    : " + df.format(price) + " VND");
        double thanhTien = price * quantity;
        double discount = isHaveCard ? thanhTien * 0.1 : 0;
        double vat = thanhTien * 0.08;
        double total = thanhTien + vat - discount;
        System.out.println("Thành tiền : " + df.format(thanhTien) + " VND");
        System.out.println("Giảm giá thành viên: " + df.format(discount) + " VND");
        System.out.println("Tiền VAT (8%): " + df.format(vat) + " VND");
        System.out.println("Tổng thanh toán: " + df.format(total) + " VND");

    }
}
