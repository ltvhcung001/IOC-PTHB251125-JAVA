import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Product> availableProducts = new ArrayList<>();
    private static ShoppingCart cart = new ShoppingCart();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        availableProducts.add(new Product("P01", "iPhone 15", 22000000));
        availableProducts.add(new Product("P02", "MacBook M3", 35000000));
        availableProducts.add(new Product("P03", "AirPods Pro", 5500000));

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n============= MENU =============");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("0. Thoát");
            System.out.println("================================");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        showAvailableProducts();
                        break;
                    case 2:
                        addProductToCart();
                        break;
                    case 3:
                        removeProductFromCart();
                        break;
                    case 4:
                        cart.displayCart();
                        break;
                    case 5:
                        cart.checkout();
                        break;
                    case 0:
                        System.out.println("Tạm biệt!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số tương ứng với Menu!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void showAvailableProducts() {
        System.out.println("\n--- DANH SÁCH SẢN PHẨM CÓ SẴN ---");
        for (Product p : availableProducts) {
            System.out.println(p);
        }
    }

    private static void addProductToCart() throws Exception {
        showAvailableProducts();
        System.out.print("Nhập mã sản phẩm muốn mua: ");
        String id = sc.nextLine();
        
        Product selected = null;
        for (Product p : availableProducts) {
            if (p.getId().equalsIgnoreCase(id)) {
                selected = p;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Lỗi: Mã sản phẩm không tồn tại!");
            return;
        }

        System.out.print("Nhập số lượng: ");
        try {
            int qty = Integer.parseInt(sc.nextLine());
            if (qty <= 0) throw new Exception("Lỗi: Số lượng không hợp lệ!");
            cart.addToCart(selected, qty);
            System.out.println("Đã thêm vào giỏ hàng.");
        } catch (NumberFormatException e) {
            throw new Exception("Lỗi: Số lượng không hợp lệ!");
        }
    }

    private static void removeProductFromCart() throws Exception {
        cart.displayCart();
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = sc.nextLine();
        cart.removeFromCart(id);
        System.out.println("Đã xóa sản phẩm thành công.");
    }
}