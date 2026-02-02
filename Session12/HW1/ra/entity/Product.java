package ra.entity;

import java.util.List;
import java.util.Scanner;

public class Product {
    private static int nextId = 1;
    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {
        this.productId = nextId++;
    }

    public Product(String productName, float price, String category, int quantity) {
        this.productId = nextId++;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void inputData(Scanner scanner, List<Product> list) {
        // Nhập tên sản phẩm
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
            this.productName = scanner.nextLine();
            if (this.productName.length() >= 10 && this.productName.length() <= 50) {
                boolean isExist = false;
                for (Product p : list) {
                    if (p.getProductName().equalsIgnoreCase(this.productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) break;
                else System.err.println("Tên sản phẩm đã tồn tại!");
            } else {
                System.err.println("Tên sản phẩm phải từ 10-50 ký tự!");
            }
        }

        // Nhập giá
        while (true) {
            System.out.print("Nhập giá sản phẩm (>0): ");
            try {
                this.price = Float.parseFloat(scanner.nextLine());
                if (this.price > 0) break;
                else System.err.println("Giá phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số thực!");
            }
        }

        // Nhập loại
        while (true) {
            System.out.print("Nhập loại sản phẩm (tối đa 200 ký tự): ");
            this.category = scanner.nextLine();
            if (this.category.length() > 0 && this.category.length() <= 200) break;
            else System.err.println("Độ dài không hợp lệ!");
        }

        // Nhập số lượng
        while (true) {
            System.out.print("Nhập số lượng tồn kho (>=0): ");
            try {
                this.quantity = Integer.parseInt(scanner.nextLine());
                if (this.quantity >= 0) break;
                else System.err.println("Số lượng không được âm!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên!");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %-20s | Giá: %-10.2f | Loại: %-15s | SL: %d",
                productId, productName, price, category, quantity);
    }
}