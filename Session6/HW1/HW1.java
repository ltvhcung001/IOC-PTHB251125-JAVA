import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HW1 {
    public static void sort(ArrayList<Double> arr){
        for (int i = 0; i < arr.size(); i++){
            for (int j = i + 1; j < arr.size(); j++){
                if (arr.get(i) > arr.get(j)){
                    Collections.swap(arr, i, j);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> arr = new ArrayList<>();
        double sum = 0.0;
        int cnt_pass = 0;
        int index = 1;
        while (true) {

            System.out.println("****************** QUẢN LÝ ĐIỂM SV ******************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và điểm thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String temp = sc.nextLine();
            int choice = 0;
            try{
                choice = Integer.parseInt(temp);
            }
            catch(Exception e){

            }
            if (choice == 1){
                while(true){
                    System.out.print("Nhập điểm sinh viên thứ " + (index++) + " (nhập -1 để dừng): ");
                    String temp2 = sc.nextLine();
                    double point = -2;
                    try{
                        point = Double.parseDouble(temp2);
                    }
                    catch(Exception e){

                    }
                    if (point == -1) break;
                    if (point >= 0 && point <= 10) {
                        arr.add(point);
                        sum += point;
                        if (point >= 5) cnt_pass++;
                    }
                    else{
                        System.out.println("Điểm không hợp lệ, vui lòng nhập lại!");
                    }
                }   
            }
            else if (choice == 2){
                System.out.println("Danh sách điểm: ");
                for (int i = 0; i < arr.size(); i++){
                    System.out.println("Điểm sinh viên " + (i+1) + " là: " + arr.get(i));
                }
            } else if (choice == 3){
                System.out.println("Điểm trung bình của các sinh viên: " + (sum / arr.size()));
            } else if (choice == 4){
                double max_point = Collections.max(arr);
                double min_point = Collections.min(arr);
                System.out.println("Điểm cao nhất là: " + max_point);
                System.out.println("Điểm thấp nhất là: "+ min_point);
            } 
            else if (choice == 5){
                System.out.println("Số lượng sinh viên đạt (>=5.0) là: " + cnt_pass);
                System.out.println("Số lượng sinh viên trượt (<5.0) là: " + (arr.size() - cnt_pass));
            }
            else if (choice == 6){
                sort(arr);
                System.out.println("Danh sách đã được sắp xếp!");
            }
            else if (choice == 7){
                int cnt_good = 0;
                for (int i = 0; i < arr.size(); i++){
                    if (arr.get(i) >= 8.0) cnt_good++;
                }
                System.out.println("Số lượng sinh viên giỏi và xuất sắc là: " + cnt_good);
            }
            else if (choice == 8){
                sc.close();
                System.out.println("Tạm biệt!");
                return;
            }
            else {
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }    
}
