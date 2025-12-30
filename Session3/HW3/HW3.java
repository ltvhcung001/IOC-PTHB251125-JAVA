import java.text.DecimalFormat;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int salary = 0;
        int cnt = 0;
        long sum = 0L;
        long sum_bonus = 0L;
        int max_salary = Integer.MIN_VALUE;
        int min_salary = Integer.MAX_VALUE;
        DecimalFormat df = new DecimalFormat("#,###.00");
        while (true) {
            System.out.println("******************** MENU NHẬP LƯƠNG ********************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");
                    while (true) {
                        System.out.print("Nhập lương: ");
                        salary = sc.nextInt();
                        if (salary == -1){
                            break;
                        }
                        if (salary < 0 || salary > 500000000){
                            System.out.println("Lương nhập vào không hợp lệ, vui lòng nhập lại.");
                            continue;
                        }
                        else{
                            cnt++;
                            sum += salary;
                            max_salary = Integer.max(max_salary, salary);
                            min_salary = Integer.min(min_salary, salary);
                        }
                        if (salary > 100000000) sum_bonus += (0.25 * salary);
                        if (salary > 50000000){
                            sum_bonus += (0.20 * salary);
                            System.out.println("-> Phân loại: Thu nhập cao");
                        }
                        else if (salary > 15000000){
                            sum_bonus += (0.15 * salary);
                            System.out.println("-> Phân loại: Thu nhập khá");
                        }
                        else if (salary > 5000000){
                            sum_bonus += (0.1 * salary);
                            System.out.println("-> Phân loại: Thu nhập trung bình");
                        }
                        else {
                            sum_bonus += (0.05 * salary);
                            System.out.println("-> Phân loại: Thu nhập thấp");
                        }
                    }   break;
                case 2:
                    System.out.println("--- Thống kê ---");
                    System.out.println("Số nhân viên: " + cnt);
                    System.out.println("Tổng lương: " + df.format(sum) + " VND");
                    System.out.println("Lương trung bình: " + df.format(sum / cnt) + " VND");
                    System.out.println("Lương cao nhất: " + df.format(max_salary) + " VND");
                    System.out.println("Lương thấp nhất: " + df.format(min_salary) + " VND");
                    break;
                case 3:
                    System.out.println("--- Tính tổng số tiền thưởng cho nhân viên ---");
                    System.out.println("Tổng tiền thưởng cho nhân viên: " + df.format(sum_bonus) + " VND");
                    break;
                case 4:
                    sc.close();
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                    break;
            }
        }
    }
}
