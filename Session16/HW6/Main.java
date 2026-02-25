import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Nguyễn Văn A", LocalDate.of(2025, 3, 10), LocalDate.of(2025, 3, 15)));
        orders.add(new Order(2, "Trần Thị B", LocalDate.of(2025, 3, 12), null)); // Chưa giao
        orders.add(new Order(3, "Lê Văn C", LocalDate.of(2025, 3, 15), LocalDate.of(2025, 3, 18)));
        orders.add(new Order(4, "Phạm Minh D", LocalDate.of(2025, 3, 16), LocalDate.of(2025, 3, 22)));
        orders.add(new Order(5, "Hoàng Anh E", LocalDate.of(2025, 3, 20), null)); // Chưa giao

        System.out.println("--- TẤT CẢ ĐƠN HÀNG ---");
        printOrders(orders);

        System.out.println("\n--- ĐƠN HÀNG ĐÃ GIAO ---");
        List<Order> delivered = orders.stream()
                .filter(o -> o.getDeliveryDate().isPresent())
                .collect(Collectors.toList());
        printOrders(delivered);

        System.out.println("\n--- ĐƠN HÀNG CHƯA GIAO ---");
        orders.stream()
                .filter(o -> o.getDeliveryDate().isEmpty())
                .forEach(o -> System.out.println(o.toDisplayString()));

        LocalDate start = LocalDate.of(2025, 3, 17);
        LocalDate end = LocalDate.of(2025, 3, 23);
        
        long count = orders.stream()
                .filter(o -> o.getDeliveryDate().isPresent())
                .filter(o -> {
                    LocalDate dDate = o.getDeliveryDate().get();
                    return !dDate.isBefore(start) && !dDate.isAfter(end);
                })
                .count();

        System.out.println("\nSố đơn hàng giao từ " + start + " đến " + end + " là: " + count);
    }

    public static void printOrders(List<Order> list) {
        list.forEach(o -> System.out.println(o.toDisplayString()));
    }
}