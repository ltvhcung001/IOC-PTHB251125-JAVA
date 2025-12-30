import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HW3 {
    public static void sort(ArrayList<String> arr){
        for (int i = 0; i < arr.size(); i++){
            for (int j = i + 1; j < arr.size(); j++){
                if (arr.get(i).compareTo(arr.get(j)) > 0){
                    Collections.swap(arr, i, j);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        int index = 1;
        while (true) {
            System.out.println("********************** QUẢN LÝ BIỂN SỐ XE **********************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm kiếm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
           String temp = sc.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e) {
            }
            if (choice == 1) {
                while (true) {
                    System.out.print("Nhập biển số thứ " + (index++) + " (nhập -1 để dừng): ");
                    String temp2 = sc.nextLine();
                    int flag = 0;
                    try{
                       flag = Integer.parseInt(temp2);
                    }
                    catch (Exception e){

                    }
                    if (flag == -1) break;
                    else arr.add(temp2);
                }
            } else if (choice == 2) {
                System.out.println("Danh sách biển số xe: ");
                for(int i  = 0; i < arr.size(); i++)
                    System.out.println("\tBiển số xe thứ " + (i+1) + " là: " + arr.get(i));
            } else if (choice == 3) {
                boolean flag = false;
                System.out.print("Nhập biển số xe: ");
                String key = sc.nextLine();
                for (int i = 0; i < arr.size(); i++){
                    if (key.equals(arr.get(i))){
                        System.out.println("Biển số xe " + key + " có tồn tại trong danh sách tại vị trí " + (i + 1));
                        flag = true;
                        break;
                    }
                }
                if (!flag) System.out.println("Biển số xe " + key + " không tồn tại trong danh sách!");
            } else if (choice == 4) {
                boolean flag = false;
                System.out.print("Nhập mã tỉnh");
                String key = sc.nextLine();
                for (int i = 0; i < arr.size(); i++){
                    if (arr.get(i).startsWith(key)){
                        flag = true;
                        System.out.println("Biển số xe " + arr.get(i) + " bắt đầu bằng mã tỉnh trên.");
                    }
                }
                if (!flag) System.out.println("Không có biển số xe nào bắt đầu bằng mã tỉnh trên!");
            } else if (choice == 5) {
                sort(arr);
                System.out.println("Danh sách biển số xe đã được sắp xếp!");
            } else if (choice == 6) {
                sc.close();
                System.out.println("Tạm biệt!");
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
}
