import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void removeFromCart(String productId) throws Exception {
        boolean found = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(productId)) {
                items.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new Exception("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
        }
    }

    public void displayCart() {
    if (items.isEmpty()) {
        System.out.println("Giỏ hàng của bạn đang trống.");
        return;
    }
    System.out.println("\n--- CHI TIẾT GIỎ HÀNG ---");
    System.out.printf("%-10s %-18s %-6s | %s\n", "Mã SP", "Tên sản phẩm", "SL", "Thành tiền");
    System.out.println("----------------------------------------------------------");
    for (CartItem item : items) {
        System.out.println(item);
    }
}

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Không có gì để thanh toán.");
            return;
        }
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubTotal();
        }
        displayCart();
        System.out.println("------------------------------------------");
        System.out.printf("TỔNG TIỀN THANH TOÁN: %,.0f VNĐ\n", total);
        items.clear(); 
    }
}