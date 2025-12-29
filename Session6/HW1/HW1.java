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

            System.out.println("****************** QUAN LY DIEM SV ******************");
            System.out.println("1. Nhap danh sach diem sinh vien");
            System.out.println("2. In danh sach diem");
            System.out.println("3. Tinh diem trung binh cua cac sinh vien");
            System.out.println("4. Tim diem cao nhat va thap nhat");
            System.out.println("5. Dem so luong sinh vien dat va truot");
            System.out.println("6. Sap xep diem tang dan");
            System.out.println("7. Thong ke so luong sinh vien gioi va xuat sac");
            System.out.println("8. Thoat");
            System.out.print("Lua chon cua ban: ");

            String temp = sc.nextLine();
            int choice = 0;
            try{
                choice = Integer.parseInt(temp);
            }
            catch(Exception e){

            }
            if (choice == 1){
                while(true){
                    System.out.print("Nhap diem sinh vien thu " + (index++) + " (nhap -1 de dung): ");
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
                        System.out.println("Diem khong hop le, vui long nhap lai!");
                    }
                }   
            }
            else if (choice == 2){
                System.out.println("Danh sach diem: ");
                for (int i = 0; i < arr.size(); i++){
                    System.out.println("Diem sinh vien " + (i+1) + " la: " + arr.get(i));
                }
            } else if (choice == 3){
                System.out.println("Diem trung binh cua cac sinh vien: " + (sum / arr.size()));
            } else if (choice == 4){
                double max_point = Collections.max(arr);
                double min_point = Collections.min(arr);
                System.out.println("Diem cao nhat la: " + max_point);
                System.out.println("Diem thap nhat la: "+ min_point);
            } 
            else if (choice == 5){
                System.out.println("So luong sinh vien dat (>=5.0) la: " + cnt_pass);
                System.out.println("So luong sinh vien truot (<5.0) la: " + (arr.size() - cnt_pass));
            }
            else if (choice == 6){
                sort(arr);
                System.out.println("Danh sach da duoc sap xep!");
            }
            else if (choice == 7){
                int cnt_good = 0;
                for (int i = 0; i < arr.size(); i++){
                    if (arr.get(i) >= 8.0) cnt_good++;
                }
                System.out.println("So luong sinh vien gioi va xuat sac la: " + cnt_good);
            }
            else if (choice == 8){
                sc.close();
                System.out.println("Tam biet!");
                return;
            }
            else {
                System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        }
    }    
}
