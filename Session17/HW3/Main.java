import java.util.Scanner;

public class Main {
    private static BookManager manager = new BookManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Cập nhật sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm kiếm theo tác giả");
            System.out.println("5. Hiển thị tất cả sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addBookAction(); break;
                    case 2: updateBookAction(); break;
                    case 3: deleteBookAction(); break;
                    case 4: searchAction(); break;
                    case 5: manager.listAllBooks(); break;
                    case 0: System.exit(0);
                    default: System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập số!");
            } catch (Exception e) {
                System.err.println("Lỗi hệ thống: " + e.getMessage());
            }
        }
    }

    private static void addBookAction() throws Exception {
        System.out.print("Tên sách: "); String title = sc.nextLine();
        System.out.print("Tác giả: "); String author = sc.nextLine();
        System.out.print("Năm xuất bản: "); int year = Integer.parseInt(sc.nextLine());
        System.out.print("Giá bán: "); double price = Double.parseDouble(sc.nextLine());
        manager.addBook(new Book(title, author, year, price));
    }

    private static void updateBookAction() throws Exception {
        System.out.print("Nhập ID sách cần cập nhật: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("Tên mới: "); String title = sc.nextLine();
        System.out.print("Tác giả mới: "); String author = sc.nextLine();
        System.out.print("Năm mới: "); int year = Integer.parseInt(sc.nextLine());
        System.out.print("Giá mới: "); double price = Double.parseDouble(sc.nextLine());
        manager.updateBook(id, new Book(title, author, year, price));
    }

    private static void deleteBookAction() throws Exception {
        System.out.print("Nhập ID sách cần xóa: "); int id = Integer.parseInt(sc.nextLine());
        manager.deleteBook(id);
    }

    private static void searchAction() throws Exception {
        System.out.print("Nhập tên tác giả: "); String author = sc.nextLine();
        manager.findBooksByAuthor(author);
    }
}