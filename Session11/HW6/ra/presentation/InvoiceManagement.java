package ra.presentation;
import ra.entity.Invoice;
import ra.entity.Product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InvoiceManagement {
    private static Product[] arrProduct = new Product[100];
    private static int productCount = 0;
    private static Invoice[] arrInvoice = new Invoice[100];
    private static int invoiceCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n================ QUẢN LÝ HÓA ĐƠN ================");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý hóa đơn");
            System.out.println("3. Báo cáo doanh thu");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: productMenu(); break;
                case 2: invoiceMenu(); break;
                case 3: reportMenu(); break;
                case 4: System.exit(0);
            }
        }
    }


    private static void productMenu() {
        while (true) {
            System.out.println("\n---------------- QUẢN LÝ SẢN PHẨM ----------------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 6) break;

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm cần thêm: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Product p = new Product();
                        p.inputData(scanner, arrProduct, productCount);
                        arrProduct[productCount++] = p;
                    }
                    break;
                case 2:
                    for (int i = 0; i < productCount; i++) arrProduct[i].displayData();
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    String updateId = scanner.nextLine();
                    for (int i = 0; i < productCount; i++) {
                        if (arrProduct[i].getProductId().equals(updateId)) {
                            arrProduct[i].inputData(scanner, arrProduct, i);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    String delId = scanner.nextLine();
                    boolean used = false;
                    for (int i = 0; i < invoiceCount; i++) {
                        for (var detail : arrInvoice[i].getInvoiceDetails()) {
                            if (detail.getProduct().getProductId().equals(delId)) {
                                used = true; break;
                            }
                        }
                    }
                    if (used) System.err.println("Không thể xóa sản phẩm đã có trong hóa đơn!");
                    else {
                        // Logic xóa mảng đơn giản
                        for (int i = 0; i < productCount; i++) {
                            if (arrProduct[i].getProductId().equals(delId)) {
                                for (int j = i; j < productCount - 1; j++) arrProduct[j] = arrProduct[j+1];
                                productCount--;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên tìm kiếm: ");
                    String searchName = scanner.nextLine();
                    for (int i = 0; i < productCount; i++) {
                        if (arrProduct[i].getProductName().contains(searchName)) arrProduct[i].displayData();
                    }
                    break;
            }
        }
    }

    private static void invoiceMenu() {
        while (true) {
            System.out.println("\n---------------- QUẢN LÝ HÓA ĐƠN ----------------");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Hiển thị danh sách hóa đơn");
            System.out.println("3. Cập nhật thông tin hóa đơn");
            System.out.println("4. Xóa hóa đơn");
            System.out.println("5. Tìm hóa đơn theo mã");
            System.out.println("6. Tìm hóa đơn theo tên khách hàng");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 7) break;

            switch (choice) {
                case 1:
                    Invoice inv = new Invoice();
                    inv.inputData(scanner, arrProduct, productCount);
                    arrInvoice[invoiceCount++] = inv;
                    break;
                case 2:
                    for (int i = 0; i < invoiceCount; i++) arrInvoice[i].displayData();
                    break;
                case 5:
                    System.out.print("Nhập mã HD: ");
                    String id = scanner.nextLine();
                    for (int i = 0; i < invoiceCount; i++) {
                        if (arrInvoice[i].getInvoiceId().equals(id)) arrInvoice[i].displayData();
                    }
                    break;
                // Các case khác thực hiện tương tự Product Management
            }
        }
    }

    private static void reportMenu() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            System.out.println("\n---------------- QUẢN LÝ DOANH THU ----------------");
            System.out.println("1. Tính tổng doanh thu tất cả hóa đơn");
            System.out.println("2. Tìm hóa đơn có giá trị lớn nhất");
            System.out.println("3. Thống kê số hóa đơn theo khoảng ngày");
            System.out.println("4. Thống kê tổng doanh thu theo khoảng ngày");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 5) break;

            switch (choice) {
                case 1:
                    double total = 0;
                    for (int i = 0; i < invoiceCount; i++) total += arrInvoice[i].getTotalAmount();
                    System.out.println("Tổng doanh thu: " + total);
                    break;
                case 2:
                    if (invoiceCount == 0) break;
                    Invoice max = arrInvoice[0];
                    for (int i = 1; i < invoiceCount; i++) {
                        if (arrInvoice[i].getTotalAmount() > max.getTotalAmount()) max = arrInvoice[i];
                    }
                    System.out.println("Hóa đơn lớn nhất:");
                    max.displayData();
                    break;
                case 4:
                    try {
                        System.out.print("Từ ngày (dd/MM/yyyy): ");
                        Date start = sdf.parse(scanner.nextLine());
                        System.out.print("Đến ngày (dd/MM/yyyy): ");
                        Date end = sdf.parse(scanner.nextLine());
                        double rangeTotal = 0;
                        for (int i = 0; i < invoiceCount; i++) {
                            if (!arrInvoice[i].getInvoiceDate().before(start) && !arrInvoice[i].getInvoiceDate().after(end)) {
                                rangeTotal += arrInvoice[i].getTotalAmount();
                            }
                        }
                        System.out.println("Tổng doanh thu trong khoảng: " + rangeTotal);
                    } catch (Exception e) {
                        System.err.println("Ngày không hợp lệ!");
                    }
                    break;
            }
        }
    }
}
