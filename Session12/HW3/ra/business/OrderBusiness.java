package ra.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import ra.entity.Order;

public class OrderBusiness {
    private List<Order> listOrders = new ArrayList<>();

    public void addOrder(Scanner scanner) {
        Order newOrder = new Order();
        newOrder.inputData(scanner);
        listOrders.add(newOrder);
        System.out.println("Thêm đơn hàng thành công!");
    }

    public void displayOrdersSortedByAmount() {
        if (listOrders.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        listOrders.stream()
                .sorted(Comparator.comparing(Order::getOrderAmount).reversed())
                .forEach(System.out::println);
    }

    public void updateOrderStatus(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Order> orderOpt = listOrders.stream().filter(o -> o.getOrderId() == id).findFirst();

        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            String currentStatus = order.getStatus();
            System.out.println("Trạng thái hiện tại: " + currentStatus);

            if (currentStatus.equals("Pending")) {
                order.setStatus("Shipped");
                System.out.println("Đã cập nhật: Pending -> Shipped");
            } else if (currentStatus.equals("Shipped")) {
                order.setStatus("Delivered");
                System.out.println("Đã cập nhật: Shipped -> Delivered");
            } else {
                System.err.println("Đơn hàng đã ở trạng thái cuối cùng (Delivered)!");
            }
        } else {
            System.err.println("Không tìm thấy mã đơn hàng!");
        }
    }

    public void deleteOrder(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Order> orderOpt = listOrders.stream().filter(o -> o.getOrderId() == id).findFirst();

        if (orderOpt.isPresent()) {
            if (orderOpt.get().getStatus().equals("Pending")) {
                listOrders.remove(orderOpt.get());
                System.out.println("Xóa thành công!");
            } else {
                System.err.println("Chỉ có thể xóa đơn hàng ở trạng thái Pending!");
            }
        } else {
            System.err.println("Mã đơn hàng không tồn tại!");
        }
    }

    public void searchByCustomerName(Scanner scanner) {
        System.out.print("Nhập tên khách hàng cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        listOrders.stream()
                .filter(o -> o.getCustomerName().toLowerCase().contains(name))
                .forEach(System.out::println);
    }

    // 6. Thống kê tổng số đơn hàng
    public void countTotalOrders() {
        System.out.println("Tổng số đơn hàng hiện có: " + listOrders.size());
    }

    // 7. Thống kê tổng doanh thu từ các đơn hàng có trạng thái "Delivered"
    public void sumRevenueDelivered() {
        double totalRevenue = listOrders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase("Delivered"))
                .mapToDouble(Order::getOrderAmount)
                .sum();
        System.out.printf("Tổng doanh thu các đơn hàng đã giao (Delivered): %.2f\n", totalRevenue);
    }

    // 8. Thống kê số lượng đơn hàng theo từng trạng thái
    public void countOrdersByStatus() {
        System.out.println("Số lượng đơn hàng theo từng trạng thái:");
        Map<String, Long> statusCount = listOrders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));

        // Đảm bảo hiển thị cả các trạng thái nếu chưa có đơn nào (tùy chọn)
        if (statusCount.isEmpty()) {
            System.out.println(" - Chưa có đơn hàng nào.");
        } else {
            statusCount.forEach((status, count) ->
                    System.out.println(" + " + status + ": " + count));
        }
    }
    // 9. Tìm kiếm đơn hàng có giá trị lớn nhất
    public void findMaxAmountOrder() {
        // Sử dụng Stream API để tìm phần tử lớn nhất dựa trên thuộc tính orderAmount
        listOrders.stream()
                .max(Comparator.comparing(Order::getOrderAmount))
                .ifPresentOrElse(
                        order -> {
                            System.out.println("--- Đơn hàng có giá trị lớn nhất là ---");
                            System.out.println(order.toString());
                        },
                        () -> System.err.println("Danh sách đơn hàng hiện đang trống!")
                );
    }
}