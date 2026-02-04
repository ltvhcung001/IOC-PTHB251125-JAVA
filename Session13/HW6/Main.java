import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contact> contactList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int idCounter = 1; 

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n---------------- MENU ----------------");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc theo số điện thoại");
            System.out.println("3. Tìm kiếm liên lạc");
            System.out.println("4. Hiển thị danh bạ");
            System.out.println("0. Thoát");
            System.out.println("--------------------------------------");
            System.out.print("Lựa chọn của bạn: ");
            
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    deleteContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    displayContacts();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void addContact() {
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = sc.nextLine();

        boolean exists = false;
        for (Contact c : contactList) {
            if (c.getPhoneNumber().equals(phone)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Lỗi: Số điện thoại đã tồn tại trong danh bạ!");
        } else {
            contactList.add(new Contact(idCounter++, name, phone));
            System.out.println("Thêm liên lạc thành công.");
        }
    }

    private static void deleteContact() {
        System.out.print("Nhập số điện thoại cần xóa: ");
        String phone = sc.nextLine();
        
        boolean removed = contactList.removeIf(c -> c.getPhoneNumber().equals(phone));
        
        if (removed) {
            System.out.println("Xóa thành công.");
        } else {
            System.out.println("Không tìm thấy liên lạc với số điện thoại này.");
        }
    }

    private static void searchContact() {
        System.out.print("Nhập số điện thoại cần tìm: ");
        String phone = sc.nextLine();
        boolean found = false;

        for (Contact c : contactList) {
            if (c.getPhoneNumber().equals(phone)) {
                System.out.println("Kết quả tìm thấy: " + c);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Số điện thoại không tồn tại trong danh bạ.");
        }
    }

    private static void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Danh bạ hiện đang trống.");
            return;
        }
        System.out.println("\n--- DANH BẠ ĐIỆN THOẠI ---");
        for (Contact c : contactList) {
            System.out.println(c);
        }
    }
}