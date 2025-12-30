import java.util.Scanner;

public class HW1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập bán kính: ");
        double r = sc.nextDouble();
        System.out.printf("Diện tích: %.2f\n", r*r*3.14);
        sc.close();
    }
}
