import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n = ");
        int n = sc.nextInt();
        if (n < 0) n = -n;
        int temp = n;
        int sum = 0;
        while(temp > 0){
            sum += temp % 10;
            temp /= 10;
        }
        System.out.printf("Tong cac chu so la: %d", sum);
        sc.close();
    }
}
