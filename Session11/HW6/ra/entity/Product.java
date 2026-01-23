package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private ProductStatus productStatus;

    public Product(){}

    public Product(String productId, String productName, double price, ProductStatus productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public ProductStatus getProductStatus() {
        return productStatus;
    }
    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int index){
        System.out.print("Nhập mã sản phẩm (C/S/A + xxxx, vd: C0001): ");
        while(true){
            this.productId = scanner.nextLine();
            if (this.productId.matches("[CSA]\\d{4}")){
                boolean isExist = false;
                for(int i = 0; i < index; i++){
                    if(arrProd[i].getProductId().equals(this.productId)){
                        isExist = true;
                    }
                }

                if (!isExist) break;
                else System.err.println("Mã sản phẩm đã tồn lại, vui lòng nhập lại.");
            }
            else{
                System.err.println("Mã sản phẩm không đúng định dạng, vui lòng nhập lại!");
            }
        }

        System.out.println("Nhập tên sản phẩm (10-50 ký tự): ");
        while (true) {
            this.productName = scanner.nextLine();
            if (this.productName.length() >= 10 && this.productName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < index; i++) {
                    if (arrProd[i].getProductName().equalsIgnoreCase(this.productName)) {
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

        System.out.println("Nhập giá sản phẩm (>0): ");
        while (true) {
            try {
                this.price = Double.parseDouble(scanner.nextLine());
                if (this.price > 0) break;
                else System.err.println("Giá phải lớn hơn 0!");
            } catch (Exception e) {
                System.err.println("Vui lòng nhập số!");
            }
        }

        System.out.println("Chọn trạng thái (1. AVAILABLE, 2. OUT_OF_STOCK, 3. STOP_SELLING): ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1: this.productStatus = ProductStatus.AVAILABLE; break;
            case 2: this.productStatus = ProductStatus.OUT_OF_STOCK; break;
            case 3: this.productStatus = ProductStatus.STOP_SELLING; break;
            default: this.productStatus = ProductStatus.AVAILABLE;
        }
    }

    public void displayData() {
        System.out.printf("ID: %-5s | Tên: %-20s | Giá: %-10.2f | Trạng thái: %-15s\n",
                productId, productName, price, productStatus);
    }
}
