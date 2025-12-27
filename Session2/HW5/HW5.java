import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n = ");
        int n = sc.nextInt();

        if (n < 100 || n > 999) 
            System.out.println("So nhap vao khong hop le");
        else{
            int units = n % 10;
            int tens = n % 100 / 10;
            int hundreds = n /100;
            
            StringBuilder s = new StringBuilder();
            switch (hundreds) {
                case 1:
                    s.append("Mot tram");
                    break;
                case 2:
                    s.append("Hai tram");
                    break;
                case 3:
                    s.append("Ba tram");
                    break;
                case 4:
                    s.append("Bon tram");
                    break;
                case 5:
                    s.append("Nam tram");
                    break;
                case 6:
                    s.append("Sau tram");
                    break;
                case 7:
                    s.append("Bay tram");
                    break;
                case 8:
                    s.append("Tam tram");
                    break;
                case 9:
                    s.append("Chin tram");
                    break;
                default:
                    break;
            }

            switch (tens) {
                case 1:
                    s.append(" muoi ");
                    break;
                case 2:
                    s.append(" hai muoi ");
                    break;
                case 3:
                    s.append(" ba muoi ");
                    break;
                case 4:
                    s.append(" bon muoi ");
                    break;
                case 5:
                    s.append(" nam muoi ");
                    break;
                case 6:
                    s.append(" sau muoi ");
                    break;
                case 7:
                    s.append(" bay muoi ");
                    break;
                case 8:
                    s.append(" tam muoi ");
                    break;
                case 9:
                    s.append(" chin muoi ");
                    break;
                default:
                    break;
            }
            if (tens == 0 && units != 0) s.append(" le ");
            switch (units) {
                case 1:
                    s.append("mot");
                    break;
                case 2:
                    s.append("hai");
                    break;
                case 3:
                    s.append("ba");
                    break;
                case 4:
                    s.append("bon");
                    break;
                case 5:
                    if(tens == 0) s.append("nam");
                    else s.append("lam");
                    break;
                case 6:
                    s.append("sau");
                    break;
                case 7:
                    s.append("bay");
                    break;
                case 8:
                    s.append("tam");
                    break;
                case 9:
                    s.append("chin");
                    break;
                default:
                    break;
            }

            System.out.println(s);
        }


        sc.close();
    }
}
