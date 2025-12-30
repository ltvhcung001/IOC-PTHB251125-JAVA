

import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float width, height;
        System.out.print("Nhập chiều dài = ");
        width = sc.nextFloat();
        System.out.print("Nhập chiều rộng = ");
        height = sc.nextFloat();
        float area = width * height;
        System.out.printf("Diện tích = %.2f\n", area);
        float perimeter = 2 * (width + height);
        System.out.printf("Chu vi = %.2f\n", perimeter);
        sc.close();
    }
}
