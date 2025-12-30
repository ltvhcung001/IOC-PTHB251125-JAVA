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
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Đếm số ký tự thường, hoa, số,");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome");
            System.out.println("5. Chuẩn hóa chuoi");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.print("Nhập chuỗi: ");
                sc.nextLine();
                str = sc.nextLine();
            }
            else if (choice == 2) {
                System.out.println("Số ký tự thường: " + countLowerCase(str));
                System.out.println("Số ký tự hoa: " + countUpperCase(str));
                System.out.println("Số chữ số: " + countDigit(str));
                System.out.println("Số ký tự đặc biệt: " + (str.length() - countDigit(str) - countLowerCase(str) - countUpperCase(str)));
            }
            else if (choice == 3){
                StringBuilder sb = new StringBuilder(str);
                System.out.println("Chuỗi đảo ngược: " + sb.reverse());
            }
            else if (choice == 4){
                StringBuilder sb = new StringBuilder(str);
                if (str.equals(sb)){
                    System.out.println("Chuỗi là chuỗi Palindrome");
                }
                else{
                    System.out.println("Chuỗi không phải là chuỗi Palindrome");
                }
            }
            else if (choice == 5){
                StringBuilder sb = new StringBuilder(str.trim());
                String[] arr = sb.toString().split(" ");
                System.out.print("Chuỗi sau khi chuẩn hóa: ");
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
                System.out.println("Tạm biệt!");
                return;
            }
            else {
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
}
