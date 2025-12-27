import java.util.Scanner;

public class HW2 {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cnt = 0;
        double max_score = Double.MIN_VALUE;
        double min_score = Double.MAX_VALUE;
        double sum = 0.0;
        
        while (true) {
            System.out.println("**************** MENU NHAP DIEM ****************");
            System.out.println("1. \t Nhap diem hoc vien");
            System.out.println("2. \t Hien thi thong ke");
            System.out.println("3. \t Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = sc.nextInt();

            if (choice == 1){
                System.out.println("--- Nhap diem hoc vien (nhap -1 de dung) ---");
                double point = 0;
                while(true){
                    System.out.print("Nhap diem: ");
                    point = sc.nextDouble();
                    if (point == -1) break;
                    if (point < -1 || point > 10) {
                        System.err.println("Diem khong hop le. Nhap lai.");
                        continue;
                    }
                    else{
                        cnt++;
                        sum += point;
                        max_score = Double.max(max_score, point);
                        min_score = Double.min(min_score, point);
                    }
                    if (point >= 9) System.out.println("Hoc luc: Xuat sac");
                    else if (point >= 8) System.out.println("Hoc luc: Gioi");
                    else if (point >= 7) System.out.println("Hoc luc: Kha");
                    else if (point >= 5) System.out.println("Hoc luc: Trung binh");
                    else System.out.println("Hoc luc: Yeu");
                }            
            }
            else if (choice == 2){
                if (cnt == 0) System.out.println("Chua co du lieu");
                else{
                    System.out.println("--- KET QUA ---");
                    System.out.println("So hoc vien " + cnt);
                    System.out.println("Diem trung binh: " + (sum / cnt));
                    System.out.println("Diem cao nhat: " + max_score);
                    System.out.println("Diem thap nhat: " + min_score);
                }
            }
            else if (choice == 3){
                sc.close();
                System.out.println("Ket thuc chuong trinh");
                System.exit(0);
            }
        }
        
    }
}
