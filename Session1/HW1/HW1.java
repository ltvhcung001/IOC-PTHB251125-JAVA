import java.util.Scanner;

public class HW1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        System.out.printf("Dien tich: %.2f", r*r*3.14);
        sc.close();
    }
}
