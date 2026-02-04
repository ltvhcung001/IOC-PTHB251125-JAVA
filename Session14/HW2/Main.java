import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> validIntegers = new ArrayList<>();
        int invalidCount = 0;

        System.out.println("Nhập các chuỗi (Nhập 'exit' để kết thúc và xem kết quả):");

        while (true) {
            System.out.print("Nhập chuỗi: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                
                validIntegers.add(number);
            } catch (NumberFormatException e) {
                invalidCount++;
            }
        }

        System.out.println("\n--- KẾT QUẢ THỐNG KÊ ---");
        System.out.println("Số chuỗi hợp lệ: " + validIntegers.size());
        System.out.println("Số chuỗi không hợp lệ: " + invalidCount);
        System.out.println("Danh sách số nguyên hợp lệ: " + validIntegers);

        scanner.close();
    }
}