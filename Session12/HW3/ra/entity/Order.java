package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {
    private static int count = 1;
    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private String status; // Pending, Shipped, Delivered

    public Order() {
        this.orderId = count++;
        this.status = "Pending";
    }

    public Order(String customerName, String phoneNumber, String address, float orderAmount) {
        this.orderId = count++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = "Pending";
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public float getOrderAmount() { return orderAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void inputData(Scanner scanner) {
        // Validate Customer Name
        while (true) {
            System.out.print("Nhập tên khách hàng (6-100 ký tự): ");
            this.customerName = scanner.nextLine();
            if (this.customerName.length() >= 6 && this.customerName.length() <= 100) break;
            System.err.println("Tên khách hàng không hợp lệ!");
        }

        // Validate Phone Number (VN Mobile Format)
        String phoneRegex = "^(0|84)(3|5|7|8|9)[0-9]{8}$";
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            this.phoneNumber = scanner.nextLine();
            if (Pattern.matches(phoneRegex, this.phoneNumber)) break;
            System.err.println("Số điện thoại không đúng định dạng VN!");
        }

        // Validate Address
        while (true) {
            System.out.print("Nhập địa chỉ giao hàng: ");
            this.address = scanner.nextLine();
            if (!this.address.trim().isEmpty()) break;
            System.err.println("Địa chỉ không được để trống!");
        }

        // Validate Order Amount
        while (true) {
            try {
                System.out.print("Nhập giá trị đơn hàng (>0): ");
                this.orderAmount = Float.parseFloat(scanner.nextLine());
                if (this.orderAmount > 0) break;
                System.err.println("Giá trị phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số thực!");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Khách: %-15s | SĐT: %-11s | Giá: %.2f | Trạng thái: %-10s | ĐC: %s",
                orderId, customerName, phoneNumber, orderAmount, status, address);
    }
}