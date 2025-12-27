import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {
        float weight, height;
        Scanner sc = new Scanner(System.in);
        System.out.print("Can nang (kg)= ");
        weight = sc.nextFloat();
        System.out.print("Cao (m) = ");
        height = sc.nextFloat();
        System.out.printf("Chi so BMI = %.2f\n", weight / (height * height));
        sc.close();
    }    
}
