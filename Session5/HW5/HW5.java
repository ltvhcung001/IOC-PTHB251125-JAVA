import java.util.Scanner;

public class HW5 {
    public static int countLowerCase(String str){
        int cnt = 0;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >= 97 && c <= 122) cnt++;
        }
        return cnt;
    }

    public static int countUpperCase(String str){
        int cnt = 0;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) cnt++;
        }
        return cnt;
    }

    public static int countDigit(String str){
        int cnt = 0;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >= 48 && c <= 57) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (true) {
            System.out.println("*************************** MENU ***************************");
            System.out.println("1. Nhap chuoi");
            System.out.println("2. Dem so ky tu thuong, hoa, so, dac biet");
            System.out.println("3. Dao nguoc chuoi");
            System.out.println("4. Kiem tra Palindrome");
            System.out.println("5. Chuan hoa chuoi");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.print("Nhap chuoi: ");
                sc.nextLine();
                str = sc.nextLine();
            }
            else if (choice == 2) {
                System.out.println("So ky tu thuong: " + countLowerCase(str));
                System.out.println("So ky tu hoa: " + countUpperCase(str));
                System.out.println("So chu so: " + countDigit(str));
                System.out.println("So ky tu dac biet: " + (str.length() - countDigit(str) - countLowerCase(str) - countUpperCase(str)));
            }
            else if (choice == 3){
                StringBuilder sb = new StringBuilder(str);
                System.out.println("Chuoi dao nguoc: " + sb.reverse());
            }
            else if (choice == 4){
                StringBuilder sb = new StringBuilder(str);
                if (str.equals(sb)){
                    System.out.println("Chuoi la chuoi Palindrome");
                }
                else{
                    System.out.println("Chuoi khong phai la chuoi Palindrome");
                }
            }
            else if (choice == 5){
                StringBuilder sb = new StringBuilder(str.trim());
                String[] arr = sb.toString().split(" ");
                System.out.print("Chuoi sau khi chuan hoa: ");
                for (int i = 0; i < arr.length; i++){
                    StringBuilder sb1 = new StringBuilder(arr[i]);
                    if (i == 0){
                        if (arr[i].charAt(0) >= 97 && arr[i].charAt(0) <= 122){
                            
                            sb1.setCharAt(0, (char) (arr[i].charAt(0) - 32));
                        }
                    }
                    else{
                        if (arr[i].charAt(0) >= 65 && arr[i].charAt(0) <= 90){
                            sb1.setCharAt(0, (char) (arr[i].charAt(0) + 32));
                        }
                    }
                    System.out.print(sb1 + " ");
                }
                System.out.println();
            }
            else if (choice == 6){
                sc.close();
                System.out.println("Tam biet!");
                return;
            }
            else {
                System.out.println("Lua cho khong hop le, vui long chon lai");
            }
        }
    }
}
