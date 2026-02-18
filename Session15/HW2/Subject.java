import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Subject {
    private String code;
    private String name;
    private int credits;
    private LocalDate startDate;

    public Subject(String code, String name, int credits, LocalDate startDate) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.startDate = startDate;
    }

    // Getters và Setters
    public String getCode() { return code; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
    public LocalDate getStartDate() { return startDate; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Mã: %-8s | Tên: %-20s | Tín chỉ: %-2d | Ngày bắt đầu: %s",
                code, name, credits, startDate.format(formatter));
    }
}