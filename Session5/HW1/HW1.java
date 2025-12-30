import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập email kiểm tra: ");
        String s = sc.nextLine();
        s = s.trim();
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";
        if (s.matches(regex))
            System.out.println("Email hợp lệ!");
        else System.out.println("Email không hợp lệ!");
        sc.close();
    }
}
