import java.text.DecimalFormat;
import java.util.Scanner;

import javax.lang.model.SourceVersion;

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
            System.out.println("******************** MENU NHAP LUONG ********************");
            System.out.println("1. Nhap luong nhan vien");
            System.out.println("2. Hien thi thong ke");
            System.out.println("3. Tinh tong so tien thuong cho nhan vien");
            System.out.println("4. Thoat");
            System.out.print("Lua chon cua ban: ");
            choice = sc.nextInt();
            

            if (choice == 1){
                System.out.println("--- Nhap luong nhan vien (nhap -1 de ket thuc) ---");
                
                while (true) {
                    System.out.print("Nhap luong: ");
                    salary = sc.nextInt();
                    if (salary == -1){
                        break;
                    }   
                    if (salary < 0 || salary > 500000000){
                        System.out.println("Luong nhap vao khong hop le. Nhap lai.");
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
                        System.out.println("-> Phan loai: Thu nhap cao");
                    }
                    else if (salary > 15000000){
                        sum_bonus += (0.15 * salary);
                        System.out.println("-> Phan loai: Thu nhap kha");
                    } 
                    else if (salary > 5000000){
                        sum_bonus += (0.1 * salary);
                        System.out.println("-> Phan loai: Thu nhap trung binh");
                    }
                    else {
                        sum_bonus += (0.05 * salary);
                        System.out.println("-> Phan loai: Thu nhap thap");
                    }
                }
            }
            else if (choice == 2){
                System.out.println("--- Thong ke ---");
                System.out.println("So nhan vien: " + cnt);
                System.out.println("Tong luong: " + df.format(sum) + " VND");
                System.out.println("Luong trung binh: " + df.format(sum / cnt) + " VND");
                System.out.println("Luong cao nhat: " + df.format(max_salary) + " VND");
                System.out.println("Luong thap nhat: " + df.format(min_salary) + " VND");
            }
            else if (choice == 3){
                System.out.println("--- Tinh tong so tien thuong nhan vien ---");
                System.out.println("Tong tien thuong nhan vien: " + df.format(sum_bonus) + " VND");
            }
            else if (choice == 4){
                sc.close();
                System.out.println("Ket thuc chuong trinh");
                System.exit(0);
            }
            else System.out.println("Lua chon khong hop le, vui long chon lai!");
        }
    }
}
