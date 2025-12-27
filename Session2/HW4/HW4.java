import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ba so duong = ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a + b <= c || b + c <= a || a + c <= b) {
            System.out.println("Ba canh khong tao thanh tam giac.");
        }
        else{
            if(a == b && b == c)
                System.out.println("Day la tam giac deu.");
            else if (a == b || b == c || c == a)
                System.out.println("Day la tam giac can.");
            else if (a * a + b * b == c * c || a * a + c * c == b * b || c * c + b * b == a * a)
                System.out.println("Day la tam giac vuong.");
            else System.out.println("Day la tam giac thuong.");
        }


        sc.close();
    }
}
