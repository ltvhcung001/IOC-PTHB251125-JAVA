import java.util.*;

public class Main {
    private static List<Product> inventory = new ArrayList<>();
    private static Map<String, Order> orders = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n================ MENU ================");
            System.out.println("1. Thêm sản phẩm vào kho");
            System.out.println("2. Xóa sản phẩm khỏi kho");
            System.out.println("3. Hiển thị danh sách kho");
            System.out.println("4. Tạo đơn hàng mới");
            System.out.println("5. Thêm sản phẩm vào đơn hàng");
            System.out.println("6. Hiển thị chi tiết đơn hàng");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addProduct(); break;
                    case 2: deleteProduct(); break;
                    case 3: showInventory(); break;
                    case 4: createOrder(); break;
                    case 5: addProductToOrder(); break;
                    case 6: showOrderDetail(); break;
                    case 0: return;
                    default: System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            } catch (BusinessException e) {
                System.out.println("LỖI NGHIỆP VỤ: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi hệ thống!");
            }
        }
    }

    // 1. Thêm sản phẩm (Xử lý giá <= 0)
    private static void addProduct() throws BusinessException {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(sc.nextLine());

        if (price <= 0) throw new BusinessException("Giá sản phẩm phải lớn hơn 0!");

        inventory.add(new Product(id, name, price));
        System.out.println("Đã thêm vào kho thành công.");
    }

    // 2. Xóa sản phẩm (Xử lý không tồn tại)
    private static void deleteProduct() throws BusinessException {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removed = inventory.removeIf(p -> p.getId() == id);

        if (!removed) throw new BusinessException("Sản phẩm ID " + id + " không tồn tại trong kho!");
        System.out.println("Xóa thành công.");
    }

    private static void showInventory() {
        System.out.println("--- KHO HÀNG ---");
        inventory.forEach(System.out::println);
    }

    // 4. Tạo đơn hàng
    private static void createOrder() {
        System.out.print("Nhập Mã đơn hàng (Số): ");
        String idStr = sc.nextLine();
        orders.put(idStr, new Order(Integer.parseInt(idStr)));
        System.out.println("Đã tạo đơn hàng trống mã " + idStr);
    }

    // 5. Thêm SP vào đơn hàng
    private static void addProductToOrder() throws BusinessException {
        System.out.print("Nhập Mã đơn hàng: ");
        String orderKey = sc.nextLine();
        if (!orders.containsKey(orderKey)) throw new BusinessException("Đơn hàng không tồn tại!");

        System.out.print("Nhập ID sản phẩm trong kho: ");
        int prodId = Integer.parseInt(sc.nextLine());

        Product p = inventory.stream()
                .filter(prod -> prod.getId() == prodId)
                .findFirst()
                .orElseThrow(() -> new BusinessException("Sản phẩm không có trong kho!"));

        orders.get(orderKey).addProduct(p);
        System.out.println("Đã thêm '" + p.getName() + "' vào đơn hàng " + orderKey);
    }

    // 6. Hiển thị đơn hàng (Xử lý truy cập đơn hàng không tồn tại)
    private static void showOrderDetail() throws BusinessException {
        System.out.print("Nhập Mã đơn hàng cần xem: ");
        String orderKey = sc.nextLine();
        Order o = orders.get(orderKey);

        if (o == null) throw new BusinessException("Truy cập thất bại: Đơn hàng không tồn tại!");

        System.out.println("--- CHI TIẾT " + o + " ---");
        o.getProducts().forEach(p -> System.out.println("  + " + p));
    }
}