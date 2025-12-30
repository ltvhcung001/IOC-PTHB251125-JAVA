import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HW6 {
    public static void sort(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        while (true) {
            System.out.println("======= QUAN LY TEN SINH VIEN =======");
            System.out.println("1. Thêm tên sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm tên sinh viên chứa từ khóa");
            System.out.println("4. Đếm số sinh viên có tên bắt đầu bằng chữ cái nhập vào");
            System.out.println("5. Sắp xếp danh sách tên theo thứ tự A-Z");
            System.out.println("6. Thoát");
            System.out.println("============================================================");
            System.out.print("Chọn: ");

            String temp = sc.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e) {
            }
            if (choice == 1) {
                System.out.print("Nhập tên sinh viên: ");
                String str = sc.nextLine();
                arr.add(str);
                System.out.println("Đã thêm " + arr.get(arr.size() - 1));
            } else if (choice == 2) {
                System.out.println("Danh sách sinh viên: ");
                for (int i = 0; i < arr.size(); i++) {
                    System.out.println("\t" + (i + 1) + ". " + arr.get(i));
                }
            } else if (choice == 3) {
                System.out.print("Nhập từ khóa: ");
                String key = sc.nextLine();
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).contains(key))
                        System.out.println("\t- " + arr.get(i));
                }
            } else if (choice == 4) {
                System.out.print("Nhập chữ cái: ");
                String key = sc.nextLine();
                int cnt = 0;
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).toLowerCase().startsWith(key.toLowerCase())) {
                        cnt++;
                    }
                }
                System.out.println("Số sinh viên có tên bắt đầu bằng '" + key.toLowerCase() + "': " + cnt);
            } else if (choice == 5) {
                sort(arr);
                System.out.println("Danh sách đã được sắp xếp A-Z");
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
