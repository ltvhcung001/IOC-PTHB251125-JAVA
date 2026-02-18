import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static MovieManager<Movie> manager = new MovieManager<>();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ PHIM ---");
            System.out.println("1. Thêm phim");
            System.out.println("2. Xóa phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Hiển thị phim");
            System.out.println("5. Tìm kiếm phim theo tên");
            System.out.println("6. Lọc phim theo rating");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": addMovie(); break;
                case "2": deleteMovie(); break;
                case "3": updateMovie(); break;
                case "4": showMovies(); break;
                case "5": searchMovie(); break;
                case "6": filterMovie(); break;
                case "7": System.out.println("Tạm biệt!"); return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addMovie() {
        try {
            System.out.print("Nhập ID phim: ");
            String id = scanner.nextLine();
            System.out.print("Nhập tiêu đề phim: ");
            String title = scanner.nextLine();
            System.out.print("Nhập đạo diễn: ");
            String director = scanner.nextLine();

            System.out.print("Nhập ngày phát hành (yyyy-MM-dd): ");
            LocalDate releaseDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

            System.out.print("Nhập rating: ");
            double rating = Double.parseDouble(scanner.nextLine());

            Movie movie = new Movie(id, title, director, releaseDate, rating);
            manager.addMovie(movie);
            System.out.println("Phim đã được thêm thành công.");
        } catch (DateTimeParseException e) {
            System.err.println("Lỗi: Định dạng ngày không đúng (yyyy-MM-dd)!");
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Rating phải là một con số!");
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    private static void deleteMovie() {
        System.out.print("Nhập ID phim cần xóa: ");
        String id = scanner.nextLine();
        if (manager.removeMovie(id)) {
            System.out.println("Phim đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy phim muốn xóa!");
        }
    }

    private static void updateMovie() {
        System.out.print("Nhập id phim muốn sửa: ");
        String id = scanner.nextLine();
        Movie found = manager.findById(id);

        if (found == null) {
            System.out.println("Không tìm thấy phim với id = " + id);
            return;
        }

        try {
            System.out.print("Nhập tiêu đề mới: ");
            found.setTitle(scanner.nextLine());
            System.out.print("Nhập đạo diễn mới: ");
            found.setDirector(scanner.nextLine());
            System.out.print("Nhập ngày phát hành mới (yyyy-MM-dd): ");
            found.setReleaseDate(LocalDate.parse(scanner.nextLine(), dateFormatter));
            System.out.print("Nhập rating mới: ");
            found.setRating(Double.parseDouble(scanner.nextLine()));
            System.out.println("Cập nhật phim thành công!");
        } catch (Exception e) {
            System.err.println("Lỗi khi cập nhật dữ liệu: " + e.getMessage());
        }
    }

    private static void showMovies() {
        List<Movie> list = manager.getAllMovies();
        if (list.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("Danh sách phim:");
            list.forEach(System.out::println);
        }
    }

    private static void searchMovie() {
        System.out.print("Nhập tên phim để tìm kiếm: ");
        String title = scanner.nextLine();
        List<Movie> results = manager.searchByTitle(title);
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy phim");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void filterMovie() {
        try {
            System.out.print("Nhập rating tối thiểu (mặc định > 8.0): ");
            String input = scanner.nextLine();
            double minRating = input.isEmpty() ? 8.0 : Double.parseDouble(input);

            List<Movie> results = manager.filterByRating(minRating);
            if (results.isEmpty()) {
                System.out.println("Không có phim nào có rating > " + minRating);
            } else {
                System.out.println("Phim có rating lớn hơn " + minRating + ":");
                results.forEach(System.out::println);
            }
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Rating phải là số!");
        }
    }
}