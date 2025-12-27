import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap thang = ");
        int month = sc.nextInt();

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.printf("Thang %d co 31 ngay.", month);
                break;
            case 4, 6, 9, 11:
                System.out.printf("Thang %d co 30 ngay.", month);
                break;
            case 2:
                System.out.printf("Thang %d co 28 hoac 29 ngay.", month);
                break;
            default:
                System.out.println("Thang khong hop le.");
                break;
        }
        sc.close();
    }
}
