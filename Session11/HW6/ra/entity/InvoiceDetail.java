package ra.entity;

import java.util.Scanner;

public class InvoiceDetail {
    private Product product;
    private int quantity;
    private double subTotal;

    public InvoiceDetail(){}

    public InvoiceDetail(Product product, int quantity, double subTotal) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex){
        System.out.println("Danh sách sản phẩm đang bán:");
        for (int i = 0; i < prodIndex; i++) {
            if (arrProd[i].getProductStatus() == ProductStatus.AVAILABLE) {
                System.out.printf("%d. %s - %s (Giá: %.2f)\n", i + 1, arrProd[i].getProductId(), arrProd[i].getProductName(), arrProd[i].getPrice());
            }
        }
        System.out.println("Chọn số thứ tự sản phẩm: ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        this.product = arrProd[choice];

        System.out.println("Nhập số lượng (>0): ");
        while (true) {
            this.quantity = Integer.parseInt(scanner.nextLine());
            if (this.quantity > 0) break;
            else System.err.println("Số lượng phải lớn hơn 0!");
        }
        this.subTotal = this.product.getPrice() * this.quantity;
    }

    public void displayData() {
        System.out.printf("Sản phẩm: %-15s | SL: %-5d | Thành tiền: %-10.2f\n",
                product.getProductName(), quantity, subTotal);
    }
}
