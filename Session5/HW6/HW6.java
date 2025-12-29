import java.util.ArrayList;
import java.util.Collection;
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
            System.out.println("1. Them ten sinh vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim ten sinh vien chua tu khoa");
            System.out.println("4. Dem so sinh vien co ten bat dau bang chu cai nhap vao");
            System.out.println("5. Sap xep danh sach ten theo thu tu A-Z");
            System.out.println("6. Thoat");
            System.out.println("============================================================");
            System.out.print("Chon: ");

            String temp = sc.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e) {
            }
            if (choice == 1) {
                System.out.print("Nhap ten sinh vien: ");
                String str = sc.nextLine();
                arr.add(str);
                System.out.println("Da them " + arr.get(arr.size() - 1));
            } else if (choice == 2) {
                System.out.println("Danh sach sinh vien: ");
                for (int i = 0; i < arr.size(); i++) {
                    System.out.println("\t" + (i + 1) + ". " + arr.get(i));
                }
            } else if (choice == 3) {
                System.out.print("Nhap tu khoa: ");
                String key = sc.nextLine();
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).contains(key))
                        System.out.println("\t- " + arr.get(i));
                }
            } else if (choice == 4) {
                System.out.print("Nhap chu cai: ");
                String key = sc.nextLine();
                int cnt = 0;
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).toLowerCase().startsWith(key.toLowerCase())) {
                        cnt++;
                    }
                }
                System.out.println("So sinh vien co ten bat dau bang '" + key.toLowerCase() + "': " + cnt);
            } else if (choice == 5) {
                sort(arr);
                System.out.println("Danh sach da duoc sap xep A-Z");
            } else if (choice == 6) {
                sc.close();
                System.out.println("Tam biet!");
                return;
            } else {
                System.out.println("Lua cho khong hop le, vui long chon lai");
            }
        }
    }
}
