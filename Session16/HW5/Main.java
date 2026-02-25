import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("An", "CNTT", 8.5),
            new Student("Bình", "Vật lý", 7.0),
            new Student("Chi", "Kinh tế", 9.0),
            new Student("Dũng", "Hoá học", 6.5),
            new Student("Giang", "Marketing", 8.0),
            new Student("Hạnh", "Sinh học", 7.5),
            new Student("Khôi", "Thiết kế đồ hoạ", 8.8),
            new Student("Lan", "Toán học", 9.2),
            new Student("Minh", "Ngôn ngữ", 7.0),
            new Student("Ngân", "Ngữ văn", 8.2),
            new Student("Oanh", "Sư phạm", 6.0)
        );

        System.out.println("--- Danh sách sinh viên ban đầu ---");
        students.forEach(System.out::println);

        Map<String, Long> majorStats = students.stream()
            .collect(Collectors.groupingBy(
                Student::getMajor, 
                Collectors.counting()
            ));

        System.out.println("\n--- Thống kê số lượng sinh viên theo chuyên ngành (Giảm dần) ---");
        
        majorStats.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(entry -> {
                System.out.println("Chuyên ngành: " + entry.getKey() + " | Số lượng: " + entry.getValue());
            });
    }
}