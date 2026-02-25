import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.0));
        products.add(new Product("Chuột máy tính", 25.0));
        products.add(new Product("Bàn phím", 80.0));
        products.add(new Product("Màn hình", 300.0));

        ProductProcessor processor = new ProductProcessorImpl();

        System.out.print("Kiểm tra sản phẩm > 100: ");
        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Có sản phẩm đắt tiền trong danh sách.");
        } else {
            System.out.println("Không có sản phẩm đắt tiền.");
        }

        double total = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị toàn bộ sản phẩm: " + total);

        ProductProcessor.printProductList(products);
    }
}