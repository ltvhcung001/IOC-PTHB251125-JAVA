import java.sql.Date;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n*********PRODUCT MANAGEMENT*********");
            System.out.println("1. Danh sách sản phẩm\n2. Thêm mới\n3. Cập nhật\n4. Xóa\n5. Tìm kiếm theo tên\n6. Sắp xếp giá tăng dần\n7. Thống kê theo danh mục\n8. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    pm.getAll().forEach(p -> System.out.println(p.getName() + " - " + p.getPrice()));
                    break;
                case 2:
                    System.out.print("Tên SP: "); String name = sc.nextLine();
                    System.out.print("Giá (>0): "); float price = sc.nextFloat(); sc.nextLine();
                    if(price <= 0) { 
                        System.out.println("Giá phải lớn hơn 0!"); 
                        break; 
                    }
                    System.out.print("Tiêu đề: "); String title = sc.nextLine();
                    System.out.print("Danh mục: "); String cat = sc.nextLine();
                    pm.addProduct(new Product(0, name, price, title, new Date(System.currentTimeMillis()), cat, true));
                    break;
                 case 3: 
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    System.out.print("Tên SP mới: "); String uName = sc.nextLine();
                    System.out.print("Giá mới (>0): "); float uPrice = sc.nextFloat(); sc.nextLine();
                    if(uPrice <= 0) { 
                        System.out.println("Giá không hợp lệ!"); 
                        break; 
                    }
                    System.out.print("Tiêu đề mới: "); String uTitle = sc.nextLine();
                    System.out.print("Danh mục mới: "); String uCat = sc.nextLine();
                    System.out.print("Trạng thái (true/false): "); boolean uStatus = sc.nextBoolean();
                    pm.updateProduct(new Product(updateId, uName, uPrice, uTitle, null, uCat, uStatus));
                    break;
                case 4: 
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    int delId = sc.nextInt();
                    pm.deleteProduct(delId);
                    break;
                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    pm.searchByName(sc.nextLine());
                    break;
                case 6: 
                    System.out.println("\n--- DANH SÁCH SẮP XẾP THEO GIÁ TĂNG DẦN ---");
                    pm.getAllSortedByPrice().forEach(p -> 
                        System.out.printf("ID: %d | %s | Giá: %.2f\n", p.getId(), p.getName(), p.getPrice()));
                    break;
                case 7:
                    pm.countByCatalog();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}