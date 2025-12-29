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
            System.out.println("********************** QUAN LY BIEN SO XE **********************");
            System.out.println("1. Them cac bien so xe");
            System.out.println("2. Hien thi danh sach bien so xe");
            System.out.println("3. Tim kiem bien so xe");
            System.out.println("4. Tim kiem bien so xe theo ma tinh");
            System.out.println("5. Sap xep bien so xe tang dan");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban: ");
            String temp = sc.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e) {
            }
            if (choice == 1) {
                while (true) {
                    System.out.print("Nhap bien so thu " + (index++) + " (nhap -1 de dung): ");
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
                System.out.println("Danh sach bien so xe: ");
                for(int i  = 0; i < arr.size(); i++)
                    System.out.println("\tBien so xe thu " + (i+1) + " la: " + arr.get(i));
            } else if (choice == 3) {
                boolean flag = false;
                System.out.print("Nhap bien so xe: ");
                String key = sc.nextLine();
                for (int i = 0; i < arr.size(); i++){
                    if (key.equals(arr.get(i))){
                        System.out.println("Bien so xe " + key + " co ton tai trong danh sach tai vi tri " + (i + 1));
                        flag = true;
                        break;
                    }
                }
                if (!flag) System.out.println("Bien so xe " + key + " khong ton tai trong danh sach!");
            } else if (choice == 4) {
                boolean flag = false;
                System.out.print("Nhap ma tinh");
                String key = sc.nextLine();
                for (int i = 0; i < arr.size(); i++){
                    if (arr.get(i).startsWith(key)){
                        flag = true;
                        System.out.println("Bien so xe " + arr.get(i) + " bat dau bang ma tinh tren.");
                    }
                }
                if (!flag) System.out.println("Khong co bien so xe nao bat dau bang ma tinh tren!");
            } else if (choice == 5) {
                sort(arr);
                System.out.println("Danh sach bien so da duoc sap xep!");
            } else if (choice == 6) {
                sc.close();
                System.out.println("Tam biet!");
                return;
            } else {
                System.out.println("Lua chon khong hop le! Vui long nhap lai!");
            }
        }
    }
}
