import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long balance = 1000000;       
        final long MIN_BALANCE = 50000; 

        System.out.println("--- CHƯƠNG TRÌNH ATM MÔ PHỎNG ---");
        System.out.println("Số dư hiện tại: " + balance + " VNĐ");

        try {
            System.out.print("Nhập số tiền muốn rút: ");
            long withdrawAmount = scanner.nextLong();

            if (withdrawAmount <= 0) {
                System.out.println("Lỗi: Số tiền rút phải lớn hơn 0!");
            } 
            else if (withdrawAmount > balance) {
                System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
            } 
            else if ((balance - withdrawAmount) < MIN_BALANCE) {
                System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            } 
            else {
                balance -= withdrawAmount;
                System.out.println("---------------------------------");
                System.out.println("Giao dịch thành công!");
                System.out.println("Số tiền đã rút: " + withdrawAmount + " VNĐ");
                System.out.println("Số dư còn lại: " + balance + " VNĐ");
            }

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        } finally {
            scanner.close();
            System.out.println("Cảm ơn quý khách đã sử dụng dịch vụ.");
        }
    }
}