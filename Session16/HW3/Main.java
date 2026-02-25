import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Message> chatHistory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dateOnlyFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        while (true) {
            System.out.print("\nNhập tên người gửi (hoặc 'exit' để thoát): ");
            String sender = scanner.nextLine().trim();
            if (sender.equalsIgnoreCase("exit")) break;

            System.out.print("Nhập nội dung tin nhắn: ");
            String content = scanner.nextLine();

            chatHistory.add(new Message(sender, content, LocalDateTime.now()));

            System.out.print("Nhập 'history' để xem lịch sử, hoặc 'filter' để lọc theo người gửi, hoặc 'date' để lọc theo ngày: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "history":
                    showHistory();
                    break;
                case "filter":
                    filterBySender();
                    break;
                case "date":
                    filterByDate();
                    break;
                default:
                    break;
            }
        }
    }

    private static void showHistory() {
        System.out.println("Lịch sử chat:");
        if (chatHistory.isEmpty()) {
            System.out.println("(Trống)");
        } else {
            chatHistory.forEach(System.out::println);
        }
    }

    private static void filterBySender() {
        System.out.print("Nhập tên người gửi cần lọc: ");
        String name = scanner.nextLine();
        System.out.println("Tin nhắn từ " + name + ":");

        chatHistory.stream()
                .filter(m -> m.getSender().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    private static void filterByDate() {
        System.out.print("Nhập ngày (dd-MM-yyyy): ");
        String dateStr = scanner.nextLine();

        try {
            LocalDate filterDate = LocalDate.parse(dateStr, dateOnlyFormatter);
            System.out.println("Tin nhắn trong ngày " + dateStr + ":");

            chatHistory.stream()
                    .filter(m -> m.getTimestamp().toLocalDate().equals(filterDate))
                    .forEach(System.out::println);

        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Định dạng ngày không hợp lệ! Vui lòng dùng dd-MM-yyyy.");
        }
    }
}