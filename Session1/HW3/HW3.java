import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tu1, tu2, mau1, mau2;

        System.out.print("Nhập tử số a1 = ");
        tu1 = sc.nextInt();
        System.out.print("Nhập mẫu số b1 = ");
        mau1 = sc.nextInt();
        System.out.print("Nhập tử số a2 = ");
        tu2 = sc.nextInt();
        System.out.print("Nhập mẫu số b2 = ");
        mau2 = sc.nextInt();

        System.out.printf("Tổng của 2 phân số là: %d/%d", tu1*mau2 + tu2*mau1, mau1 * mau2);
        sc.close();
    }    
}
