import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất (firstNumber): ");
        firstNumber = sc.nextInt();
        System.out.print("Nhập số thứ hai (secondNumber): ");
        secondNumber = sc.nextInt();

        System.out.println("--- Kết quả ---");
        System.out.printf("firstNumber = %d\n", firstNumber);
        System.out.printf("secondNumber = %d\n", secondNumber);
        System.out.printf("secondNumber = %d\n", secondNumber);
        System.out.printf("Tổng = %d\n", firstNumber + secondNumber);
        System.out.printf("Hiệu = %d\n", firstNumber - secondNumber);
        System.out.printf("Tích = %d\n", firstNumber * secondNumber);
        System.out.printf("Thương = %d\n", firstNumber / secondNumber);
        System.out.printf("Dư = %d\n", firstNumber % secondNumber);
        sc.close();
    }   



}
