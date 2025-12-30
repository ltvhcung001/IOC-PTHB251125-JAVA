
import java.util.ArrayList;
import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();
        
        OUTER:
        while (true) {
            System.out.println("===== MENU SẢN PHẨM =====");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. In danh sách sản phẩm");
            System.out.println("3. Tìm sản phẩm theo khoảng giá");
            System.out.println("4. Thống kê số sản phẩm đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String temp = sc.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e) {
            }
            switch (choice) {
                case 1 -> {
                    while (true) {
                        System.out.println("Chức năng thêm sản phẩm mới:");
                        Product pr = new Product();
                        pr.input(sc);
                        productList.add(pr);
                        System.out.println("Sản phẩm đã được thêm:");
                        pr.print();
                        System.out.println("Bạn có muốn thêm sản phẩm khác không? (y/n): ");
                        String ans = sc.nextLine();
                        if (!ans.equalsIgnoreCase("y")) {
                            System.out.println("Quay lại menu chính.");
                            break;
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Danh sách sản phẩm đã nhập:");
                    for (Product pr : productList) {
                        pr.print();
                    }
                }
                case 3 -> {
                    System.out.println("Chức năng tìm sản phẩm theo khoảng giá:");
                    System.out.print("Nhập giá thấp nhất: ");
                    double minPrice = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập giá cao nhất: ");
                    double maxPrice = Double.parseDouble(sc.nextLine());
                    System.out.println("Sản phẩm trong khoảng giá từ " + minPrice + " đến " + maxPrice + ":");
                    for (Product pr : productList) {
                        if (pr.getPrice() >= minPrice && pr.getPrice() <= maxPrice) {
                            pr.print();
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Tổng số sản phẩm đã tạo: " + Product.getTotalProducts());
                }
                case 0 -> {
                    break OUTER;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
            // In danh sách sản phẩm
            // Tìm sản phẩm theo khoảng giá
            // Thống kê số sản phẩm đã tạo
                    }
    }
}
