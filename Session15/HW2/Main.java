import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static SubjectManager<Subject> manager = new SubjectManager<>();
    private static Scanner sc = new Scanner(System.in);
    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ MÔN HỌC ---");
            System.out.println("1. Thêm môn học");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Xóa môn học theo mã");
            System.out.println("4. Tìm kiếm theo tên (Optional)");
            System.out.println("5. Lọc môn học có tín chỉ > 3");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1": addSubject(); break;
                case "2": manager.displayAll(); break;
                case "3": deleteSubject(); break;
                case "4": searchSubject(); break;
                case "5": filterSubject(); break;
                case "6": System.exit(0);
                default: System.out.println("Lựa chọn sai!");
            }
        }
    }

    private static void addSubject() {
        try {
            System.out.print("Nhập mã môn: ");
            String code = sc.nextLine();
            System.out.print("Nhập tên môn: ");
            String name = sc.nextLine();

            System.out.print("Nhập số tín chỉ: ");
            int credits = Integer.parseInt(sc.nextLine());
            // Xử lý ngoại lệ nghiệp vụ (số tín chỉ 0-10)
            if (credits < 0 || credits > 10) {
                throw new Exception("Lỗi: Số tín chỉ phải từ 0 đến 10!");
            }

            System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
            LocalDate date = LocalDate.parse(sc.nextLine(), df);

            manager.add(new Subject(code, name, credits, date));
            System.out.println("Thêm thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Tín chỉ phải là số nguyên!");
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Định dạng ngày sai (dd/MM/yyyy)!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteSubject() {
        System.out.print("Nhập mã cần xóa: ");
        String code = sc.nextLine();
        if (manager.removeByCode(code)) {
            System.out.println("Đã xóa thành công.");
        } else {
            System.out.println("Lỗi: Không tìm thấy mã môn học này!");
        }
    }

    private static void searchSubject() {
        System.out.print("Nhập tên môn cần tìm: ");
        String name = sc.nextLine();
        Optional<Subject> result = manager.findByName(name);

        // Sử dụng Optional để xử lý trường hợp không tìm thấy
        result.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Không có môn học phù hợp")
        );
    }

    private static void filterSubject() {
        System.out.println("Các môn có tín chỉ > 3:");
        manager.filterHighCredits().forEach(System.out::println);
    }
}