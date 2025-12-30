import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float velocity;
        float time;

        System.out.print("Nhập vận tốc (km/h) = ");
        velocity = sc.nextFloat();
        System.out.print("Nhập thời gian (gio) = ");
        time = sc.nextFloat();

        System.out.printf("Quãng đường (km) = %.2f", velocity * time);
        sc.close();
    }
}
