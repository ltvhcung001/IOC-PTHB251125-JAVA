import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float velocity;
        float time;

        System.out.print("Nhap van toc (km/h) = ");
        velocity = sc.nextFloat();
        System.out.print("Nhap thoi gian (gio) = ");
        time = sc.nextFloat();

        System.out.printf("Quang duong (km) = %.2f", velocity * time);
        sc.close();
    }
}
