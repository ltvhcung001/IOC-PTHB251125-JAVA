import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so thu nhat (firstNumber): ");
        firstNumber = sc.nextInt();
        System.out.print("Nhap so thu hai (secondNumber): ");
        secondNumber = sc.nextInt();

        System.out.println("--- Ket qua ---");
        System.out.printf("firstNumber = %d\n", firstNumber);
        System.out.printf("secondNumber = %d\n", secondNumber);
        System.out.printf("secondNumber = %d\n", secondNumber);
        System.out.printf("Tong = %d\n", firstNumber + secondNumber);
        System.out.printf("Hieu = %d\n", firstNumber - secondNumber);
        System.out.printf("Tich = %d\n", firstNumber * secondNumber);
        System.out.printf("Thuong = %d\n", firstNumber / secondNumber);
        System.out.printf("Du = %d\n", firstNumber % secondNumber);
        
        sc.close();
    }   



}
