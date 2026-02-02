package ra.business;

import ra.entity.Product;
import java.util.*;

public class ProductBusiness {
    public static List<Product> listProduct = new ArrayList<>();

    public static void addProduct(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Sản phẩm thứ " + (i + 1) + ":");
            Product p = new Product();
            p.inputData(scanner, listProduct);
            listProduct.add(p);
        }
        System.out.println("Thêm thành công!");
    }

    public static void displayProducts() {
        if (listProduct.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("------------------------- DANH SÁCH SẢN PHẨM -------------------------");
        for (Product p : listProduct) {
            System.out.println(p.toString());
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = findById(id);
        if (product != null) {
            System.out.println("Để trống nếu không muốn thay đổi thông tin.");
            // Logic cập nhật tương tự inputData nhưng cho phép giữ cũ nếu cần
            product.inputData(scanner, listProduct);
            System.out.println("Cập nhật thành công!");
        } else {
            System.err.println("Không tìm thấy mã sản phẩm " + id);
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = findById(id);
        if (product != null) {
            listProduct.remove(product);
            System.out.println("Xóa thành công!");
        } else {
            System.err.println("Không tìm thấy mã sản phẩm!");
        }
    }

    public static void searchByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Product p : listProduct) {
            if (p.getProductName().toLowerCase().contains(keyword)) {
                System.out.println(p.toString());
                found = true;
            }
        }
        if (!found) System.err.println("Không tìm thấy sản phẩm nào!");
    }

    public static void sortByPriceAsc() {
        listProduct.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Đã sắp xếp theo giá tăng dần.");
        displayProducts();
    }

    public static void sortByQuantityDesc() {
        listProduct.sort((p1, p2) -> p2.getQuantity() - p1.getQuantity());
        System.out.println("Đã sắp xếp theo số lượng giảm dần.");
        displayProducts();
    }

    private static Product findById(int id) {
        for (Product p : listProduct) {
            if (p.getProductId() == id) return p;
        }
        return null;
    }
}