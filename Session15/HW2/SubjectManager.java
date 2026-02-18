import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubjectManager<T extends Subject> {
    private List<T> subjects = new ArrayList<>();

    public void add(T subject) {
        subjects.add(subject);
    }

    public boolean removeByCode(String code) {
        return subjects.removeIf(s -> s.getCode().equalsIgnoreCase(code));
    }

    public void displayAll() {
        if (subjects.isEmpty()) {
            System.out.println("Danh sách môn học trống.");
        } else {
            subjects.forEach(System.out::println);
        }
    }

    // Sử dụng Stream + Optional để tìm kiếm theo tên
    public Optional<T> findByName(String name) {
        return subjects.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Sử dụng Stream để lọc tín chỉ > 3
    public List<T> filterHighCredits() {
        return subjects.stream()
                .filter(s -> s.getCredits() > 3)
                .collect(Collectors.toList());
    }
}