import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ba số dương = ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a + b <= c || b + c <= a || a + c <= b) {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }
        else{
            if(a == b && b == c)
                System.out.println("Đây là tam giác đều.");
            else if (a == b || b == c || c == a)
                System.out.println("Đây là tam giác cân.");
            else if (a * a + b * b == c * c || a * a + c * c == b * b || c * c + b * b == a * a)
                System.out.println("Đây là tam giác vuông.");
            else System.out.println("Đây là tam giác thường.");
        }
        sc.close();
    }
}
