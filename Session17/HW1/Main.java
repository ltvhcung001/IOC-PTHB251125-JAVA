import java.util.Scanner;

public class Main {
    private static MovieManagement manager = new MovieManagement();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ PHIM ---");
            System.out.println("1. Thêm phim");
            System.out.println("2. Liệt kê phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Xóa phim");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addAction(); break;
                    case 2: manager.listMovies(); break;
                    case 3: updateAction(); break;
                    case 4: deleteAction(); break;
                    case 0: return;
                    default: System.out.println("Lựa chọn sai!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }

    private static void addAction() throws Exception {
        System.out.print("Tiêu đề: "); String title = sc.nextLine();
        System.out.print("Đạo diễn: "); String director = sc.nextLine();
        System.out.print("Năm phát hành: "); int year = Integer.parseInt(sc.nextLine());

        if (title.isEmpty() || director.isEmpty()) throw new Exception("Không được để trống thông tin!");
        manager.addMovie(title, director, year);
        System.out.println("Thêm thành công!");
    }

    private static void updateAction() throws Exception {
        System.out.print("Nhập ID phim cần sửa: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("Tiêu đề mới: "); String title = sc.nextLine();
        System.out.print("Đạo diễn mới: "); String director = sc.nextLine();
        System.out.print("Năm mới: "); int year = Integer.parseInt(sc.nextLine());

        manager.updateMovie(id, title, director, year);
        System.out.println("Cập nhật thành công!");
    }

    private static void deleteAction() throws Exception {
        System.out.print("Nhập ID cần xóa: "); int id = Integer.parseInt(sc.nextLine());
        manager.deleteMovie(id);
        System.out.println("Xóa thành công!");
    }
}