import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        if (phone.contains(" ")) {
            throw new InvalidPhoneNumberLengthException("Không được chứa khoảng trắng");
        }
        
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Sai độ dài (phải có đúng 10 chữ số)");
        }
        
        if (!phone.matches("^[0-9]+$")) {
            throw new InvalidPhoneNumberLengthException("Chứa ký tự không hợp lệ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập danh sách số điện thoại (ngăn cách bằng dấu phẩy):");
        String input = sc.nextLine();
        
        String[] phoneArray = input.split(",");
        
        List<String> validList = new ArrayList<>();
        List<String> invalidList = new ArrayList<>();

        for (String p : phoneArray) {
            String phone = p.trim();
            
            try {
                validatePhoneNumber(phone);
                validList.add(phone);
            } catch (InvalidPhoneNumberLengthException e) {
                invalidList.add(phone + " : " + e.getMessage());
            }
        }

        System.out.println("\nSố điện thoại hợp lệ:");
        for (String v : validList) {
            System.out.println("- " + v);
        }

        System.out.println("\nSố điện thoại không hợp lệ:");
        for (String inv : invalidList) {
            System.out.println("- " + inv);
        }
        
        sc.close();
    }
}