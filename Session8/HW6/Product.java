import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;

    private static int AUTO_ID = 1;
    final String WAREHOUSE_CODE = "KHO-01";

    public Product() {
        this.id = AUTO_ID++;
    }
    
    public Product(String name, double price) {
        this.id = AUTO_ID++;
        this.name = name;
        this.price = price;
    }

    public void input(Scanner sc) {
        System.out.print("Nhập tên sản phẩm: ");
        this.name = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        String temp = sc.nextLine();
        try {
            this.price = Double.parseDouble(temp);
        } catch (Exception e) {
        }
    }

    public void print() {
        System.out.println("Mã sản phẩm: " + id + ", Tên sản phẩm: " + name + ", Giá sản phẩm: " + price + ", Mã kho: " + WAREHOUSE_CODE);
    }

    public double getPrice() {
        return price;
    }

    public static int getTotalProducts() {
        return AUTO_ID - 1;
    }
}
