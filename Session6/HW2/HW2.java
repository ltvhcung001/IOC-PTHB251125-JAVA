import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = new String();
        String email = new String();
        String password = new String();
        String phone = new String();
        while (true) {
            System.out.println("*********************** QUAN LY NGUOI DUNG ***********************");
            System.out.println("1. Nhap thong tin nguoi dung");
            System.out.println("2. Chuan hoa ho ten");
            System.out.println("3. Kiem tra email hop le");
            System.out.println("4. Kiem tra so dien thoai hop le");
            System.out.println("5. Kiem tra mat khau hop le");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = 0;
            String temp = sc.nextLine();
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e) {

            }

            if (choice == 1) {
                System.out.print("Nhap ho ten nguoi dung: ");
                name = sc.nextLine();
                System.out.print("Nhap email: ");
                email = sc.nextLine();
                System.out.print("Nhap so dien thoai: ");
                phone = sc.nextLine();
                System.out.print("Nhap mat khau: ");
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
                System.out.println("Ho ten da chuan hoa: " + name);
            } else if (choice == 3) {
                String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                if (email.matches(regex))
                    System.out.println("Email nay hop le!");
                else
                    System.out.println("Email khong hop le!");
            } else if (choice == 4) {
                String regex = "^0\\d{9}$";
                if (phone.matches(regex))
                    System.out.println("So dien thoai hop le!");
                else
                    System.out.println("So dien thoai khong hop le!");
            } else if (choice == 5) {
                String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
                if (password.matches(regex))
                    System.out.println("Mat khau hop le!");
                else
                    System.out.println("Mat khau khong hop le!");
            } else if (choice == 6) {
                sc.close();
                System.out.println("Tam biet!");
                return;
            } else {
                System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        }
    }
}
