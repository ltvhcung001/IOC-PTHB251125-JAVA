import java.util.ArrayList;
import java.util.List;

public class OrderManager implements Manage<Order> {
    private List<Order> orderList = new ArrayList<>();

    @Override
    public void add(Order item) {
        orderList.add(item);
    }

    @Override
    public void update(int index, Order item) {
        orderList.set(index, item);
    }

    @Override
    public void delete(int index) {
        orderList.remove(index);
    }

    @Override
    public void display() {
        if (orderList.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống.");
        } else {
            for (int i = 0; i < orderList.size(); i++) {
                // Hiển thị số thứ tự 1, 2, 3... giống trong ảnh mẫu
                System.out.println((i + 1) + ". " + orderList.get(i));
            }
        }
    }

    // Hàm tìm vị trí index dựa trên Mã đơn hàng (String)
    public int findIndexByCode(String code) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }
}