import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {
    double calculateTotalValue(List<Product> products);

    static void printProductList(List<Product> products) {
        System.out.println("--- Danh sách sản phẩm ---");
        products.forEach(System.out::println);
    }

    default boolean hasExpensiveProduct(List<Product> products) {
        Predicate<Product> isExpensive = p -> p.getPrice() > 100;
        
        return products.stream().anyMatch(isExpensive);
    }
}