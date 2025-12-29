import java.util.Scanner;
import java.util.regex.Pattern;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mat khau: ");
        String password = sc.nextLine();

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!%^&+=])(?=\\S+$).{8,}$";

        if(Pattern.matches(regex, password)){
            System.out.println("Mat khau hop le");
        }
        else{
            System.out.println("Mat khau khong hop le");
        }



        sc.close();
    }
}
