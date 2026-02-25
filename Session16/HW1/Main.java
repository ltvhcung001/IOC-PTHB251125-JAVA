import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Product> productMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": addProduct(); break;
                case "2": editProduct(); break;
                case "3": deleteProduct(); break;
                case "4": displayProducts(); break;
                case "5": filterProducts(); break;
                case "6": calculateTotalValue(); break;
                case "0": System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        productMap.put(id, new Product(id, name, price));
        System.out.println("Product added successfully.");
    }

    private static void editProduct() {
        System.out.print("Enter Product ID to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (productMap.containsKey(id)) {
            System.out.print("Enter new Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Product Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            Product p = productMap.get(id);
            p.setName(name);
            p.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (productMap.remove(id) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void displayProducts() {
        if (productMap.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            // Duyệt HashMap và in ra giá trị
            productMap.values().forEach(System.out::println);
        }
    }

    private static void filterProducts() {
        System.out.println("Products with price greater than 100:");
        productMap.values().stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }

    private static void calculateTotalValue() {
        double total = productMap.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total value of products: " + total);
    }
}