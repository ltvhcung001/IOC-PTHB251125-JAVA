import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n = ");
        int n = sc.nextInt();

        if (n < 100 || n > 999) 
            System.out.println("Số nhập vào không hợp lệ.");
        else{
            int units = n % 10;
            int tens = n % 100 / 10;
            int hundreds = n /100;
            
            StringBuilder s = new StringBuilder();
            switch (hundreds) {
                case 1:
                    s.append("Một trăm");
                    break;
                case 2:
                    s.append("Hai trăm");
                    break;
                case 3:
                    s.append("Ba trăm");
                    break;
                case 4:
                    s.append("Bốn trăm");
                    break;
                case 5:
                    s.append("Năm trăm");
                    break;
                case 6:
                    s.append("Sáu trăm");
                    break;
                case 7:
                    s.append("Bảy trăm");
                    break;
                case 8:
                    s.append("Tám trăm");
                    break;
                case 9:
                    s.append("Chín trăm");
                    break;
                default:
                    break;
            }

            switch (tens) {
                case 1:
                    s.append(" mươi ");
                    break;
                case 2:
                    s.append(" hai mươi ");
                    break;
                case 3:
                    s.append(" ba mươi ");
                    break;
                case 4:
                    s.append(" bốn mươi ");
                    break;
                case 5:
                    s.append(" năm mươi ");
                    break;
                case 6:
                    s.append(" sáu mươi ");
                    break;
                case 7:
                    s.append(" bảy mươi ");
                    break;
                case 8:
                    s.append(" tám mươi ");
                    break;
                case 9:
                    s.append(" chín mươi ");
                    break;
                default:
                    break;
            }
            if (tens == 0 && units != 0) s.append(" le ");
            switch (units) {
                case 1:
                    s.append("một");
                    break;
                case 2:
                    s.append("hai");
                    break;
                case 3:
                    s.append("ba");
                    break;
                case 4:
                    s.append("bốn");
                    break;
                case 5:
                    if(tens == 0) s.append("năm");
                    else s.append("lăm");
                    break;
                case 6:
                    s.append("sáu");
                    break;
                case 7:
                    s.append("bảy");
                    break;
                case 8:
                    s.append("tám");
                    break;
                case 9:
                    s.append("chín");
                    break;
                default:
                    break;
            }
            System.out.println(s);
        }
        sc.close();
    }
}
