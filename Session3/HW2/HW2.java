import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cnt = 0;
        double max_score = Double.MIN_VALUE;
        double min_score = Double.MAX_VALUE;
        double sum = 0.0;
        
        while (true) {
            System.out.println("**************** MENU NHẬP ĐIỂM ****************");
            System.out.println("1. \t Nhập điểm học viên");
            System.out.println("2. \t Hiển thị thống kê");
            System.out.println("3. \t Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();

            if (choice == 1){
                System.out.println("--- Nhập điểm học viên (nhập -1 để dừng) ---");
                double point = 0;
                while(true){
                    System.out.print("Nhập điểm: ");
                    point = sc.nextDouble();
                    if (point == -1) break;
                    if (point < -1 || point > 10) {
                        System.err.println("Điểm không hợp lệ, vui lòng nhập lại.");
                        continue;
                    }
                    else{
                        cnt++;
                        sum += point;
                        max_score = Double.max(max_score, point);
                        min_score = Double.min(min_score, point);
                    }
                    if (point >= 9) System.out.println("Học lực: Xuất sắc");
                    else if (point >= 8) System.out.println("Học lực: Giỏi");
                    else if (point >= 7) System.out.println("Học lực: Khá");
                    else if (point >= 5) System.out.println("Học lực: Trung bình");
                    else System.out.println("Học lực: Yếu");
                }            
            }
            else if (choice == 2){
                if (cnt == 0) System.out.println("Chưa có dữ liệu.");
                else{
                    System.out.println("--- KẾT QUẢ ---");
                    System.out.println("Số học viên " + cnt);
                    System.out.println("Điểm trung bình: " + (sum / cnt));
                    System.out.println("Điểm cao nhất: " + max_score);
                    System.out.println("Điểm thấp nhất: " + min_score);
                }
            }
            else if (choice == 3){
                sc.close();
                System.out.println("Kết thúc chương trình");
                System.exit(0);
            }
        }
        
    }
}
