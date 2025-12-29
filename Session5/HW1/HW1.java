import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap email can kiem tra: ");
        String s = sc.nextLine();
        s = s.trim();
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";
        if (s.matches(regex))
            System.out.println("Email hop le!");
        else System.out.println("Email khong hop le!");
        sc.close();
    }
}
