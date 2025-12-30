import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = new String();
        String email = new String();
        String password = new String();
        String phone = new String();
        while (true) {
            System.out.println("*********************** QUẢN LÝ NGƯỜI DÙNG ***********************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = 0;
            String temp = sc.nextLine();
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e) {

            }

            if (choice == 1) {
                System.out.print("Nhập họ tên người dùng: ");
                name = sc.nextLine();
                System.out.print("Nhập email: ");
                email = sc.nextLine();
                System.out.print("Nhập số điện thoại: ");
                phone = sc.nextLine();
                System.out.print("Nhập mật khẩu: ");
                password = sc.nextLine();
            } else if (choice == 2) {
                String[] nameParts = name.trim().split(" ");
                StringBuilder normalizedName = new StringBuilder();
                for (String part : nameParts) {
                    if (part.length() > 0) {
                        normalizedName.append(Character.toUpperCase(part.charAt(0)))
                                .append(part.substring(1).toLowerCase())
                                .append(" ");
                    }
                }
                name = normalizedName.toString().trim();
                System.out.println("Họ tên đã chuẩn hóa: " + name);
            } else if (choice == 3) {
                String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                if (email.matches(regex))
                    System.out.println("Email này hợp lệ!");
                else
                    System.out.println("Email không hợp lệ!");
            } else if (choice == 4) {
                String regex = "^0\\d{9}$";
                if (phone.matches(regex))
                    System.out.println("Số điện thoại này hợp lệ!");
                else
                    System.out.println("Số điện thoại này không hợp lệ!");
            } else if (choice == 5) {
                String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
                if (password.matches(regex))
                    System.out.println("Mật khẩu hợp lệ!");
                else
                    System.out.println("Mật khẩu không hợp lệ!");
            } else if (choice == 6) {
                sc.close();
                System.out.println("Tạm biệt!");
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
}
