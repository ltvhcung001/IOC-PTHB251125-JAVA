import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private static final List<Event> eventList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            String name = scanner.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) break;

            if (name.isEmpty()) {
                System.out.println("Can not enter empty string");
                continue;
            }

            LocalDateTime start = null;
            while (start == null) {
                System.out.print("Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm): ");
                start = parseDateTime(scanner.nextLine());
                if (start == null) System.out.println("Enter not valid date");
            }

            LocalDateTime end = null;
            while (end == null) {
                System.out.print("Nhập thời gian kết thúc (dd-MM-yyyy HH:mm): ");
                end = parseDateTime(scanner.nextLine());
                if (end == null) {
                    System.out.println("Enter not valid date");
                } else if (end.isBefore(start)) {
                    System.out.println("Lỗi: Thời gian kết thúc phải sau thời gian bắt đầu!");
                    end = null;
                }
            }

            eventList.add(new Event(name, start, end));
        }

        System.out.println("\nDanh sách sự kiện:");
        if (eventList.isEmpty()) {
            System.out.println("Trống.");
        } else {
            eventList.forEach(System.out::println);
        }
    }

    private static LocalDateTime parseDateTime(String input) {
        try {
            return LocalDateTime.parse(input, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}