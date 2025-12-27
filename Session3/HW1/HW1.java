import java.text.DecimalFormat;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Nhap ten khach hang: ");
        String user_name = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        String book_name = sc.nextLine();
        System.out.print("Nhap gia san pham: ");
        double price = sc.nextDouble();
        System.out.print("Nhap so luong mua: ");
        int quantity = sc.nextInt();
        System.out.print("Khach co the thanh vien? (true/false): ");
        boolean isHaveCard = sc.nextBoolean();
        sc.close();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("==================== HOA DON ====================");
        System.out.printf("Khach hang : %s\n", user_name);
        System.out.printf("San pham   : %s\n", book_name);
        System.out.printf("So luong   : %d\n", quantity);
        System.out.println("Don gia    : " + df.format(price) + " VND");
        double thanhTien = price * quantity;
        double discount = isHaveCard ? thanhTien * 0.1 : 0;
        double vat = thanhTien * 0.08;
        double total = thanhTien + vat - discount;
        System.out.println("Thanh tien : " + df.format(thanhTien) + " VND");
        System.out.println("Giam gia thanh vien: " + df.format(discount) + " VND");
        System.out.println("Tien VAT (8%): " + df.format(vat) + " VND");
        System.out.println("Tong thanh toan: " + df.format(total) + " VND");

    }
}
