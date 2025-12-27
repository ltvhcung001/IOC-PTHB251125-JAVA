import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tu1, tu2, mau1, mau2;

        System.out.print("Nhap tu so a1 = ");
        tu1 = sc.nextInt();
        System.out.print("Nhap mau so b1 = ");
        mau1 = sc.nextInt();
        System.out.print("Nhap tu so a2 = ");
        tu2 = sc.nextInt();
        System.out.print("Nhap mau so b2 = ");
        mau2 = sc.nextInt();

        System.out.printf("Tong cua 2 phan so la: %d/%d", tu1*mau2 + tu2*mau1, mau1 * mau2);


        sc.close();
    }    
}
