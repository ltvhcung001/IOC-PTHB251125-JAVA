import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Person> personList = new LinkedList<>();
    static void main() {
        while(true){
            System.out.println("*************** MENU QUẢN LÝ NGƯỜI DÙNG ***************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    displayUsers();
                    break;
                case 4:
                    sc.close();
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng nhập lại");
            }
        }
    }

    private static String inputWithValidation(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            System.out.println("\nVui lòng ko để trống!");
        }
        return input;
    }

    private static void addUser(){
        String name = inputWithValidation("Nhập tên người dùng: ");
        String email = inputWithValidation("Nhập email: ");
        String phone = inputWithValidation("Nhập số điện thoại người dùng: ");
        personList.add(new Person(name, email, phone));
        System.out.println("Người dùng đã được thêm thành công.");
    }

    private static void deleteUser(){
        System.out.println("Nhập email người dùng cần xóa: ");
        String target_email = sc.nextLine().trim();
        boolean found = false;

        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getEmail().equalsIgnoreCase(target_email)){
                personList.remove(i);
                found = true;
                break;
            }
        }
        if (found) System.out.println("Người dùng đã được xóa thành công.");
        else System.out.println("Không tìm thấy người dùng trên");
    }

    private static void displayUsers(){
        System.out.println("Danh sách người dùng: ");
        if (personList.isEmpty()) System.out.println("Danh sách trống!");
        else{
            for (int i = 0; i < personList.size(); i++) System.out.println((i + 1) + ". " + personList.get(i).toString());
        }
    }


}