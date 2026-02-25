import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStatus() {
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(startDate)) {
            return "Sắp diễn ra";
        } else if (now.isAfter(endDate)) {
            return "Đã kết thúc";
        } else {
            return "Đang diễn ra";
        }
    }

    @Override
    public String toString() {
        return String.format("Event{name='%s', startDate=%s, endDate=%s} [%s]",
                name, startDate.format(formatter), endDate.format(formatter), getStatus());
    }
}