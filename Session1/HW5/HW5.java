import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {
        float weight, height;
        Scanner sc = new Scanner(System.in);
        System.out.print("Cân nặng (kg)= ");
        weight = sc.nextFloat();
        System.out.print("Cao (m) = ");
        height = sc.nextFloat();
        System.out.printf("Chỉ số BMI = %.2f\n", weight / (height * height));
        sc.close();
    }    
}
