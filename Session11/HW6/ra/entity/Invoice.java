package ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Invoice {
    private String invoiceId;
    private String customerName;
    private Date invoiceDate;
    private InvoiceDetail[] invoiceDetails;
    private double totalAmount;

    public Invoice(){}

    public Invoice(String invoiceId, String customerName, Date invoiceDate, InvoiceDetail[] invoiceDetails, double totalAmount) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.invoiceDetails = invoiceDetails;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Date getInvoiceDate() {
        return invoiceDate;
    }
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public InvoiceDetail[] getInvoiceDetails() {
        return invoiceDetails;
    }
    public void setInvoiceDetails(InvoiceDetail[] invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex){
        System.out.println("Nhập mã hóa đơn (HDxxxx): ");
        while (true) {
            this.invoiceId = scanner.nextLine();
            if (this.invoiceId.matches("HD\\d{4}")) break;
            else System.err.println("Mã hóa đơn không đúng định dạng (HD + 4 số)!");
        }

        System.out.println("Nhập tên khách hàng: ");
        this.customerName = scanner.nextLine();

        System.out.println("Nhập ngày lập (dd/MM/yyyy): ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                this.invoiceDate = sdf.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Định dạng ngày không đúng!");
            }
        }

        System.out.println("Nhập số lượng sản phẩm trong hóa đơn: ");
        int n = Integer.parseInt(scanner.nextLine());
        this.invoiceDetails = new InvoiceDetail[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập chi tiết sản phẩm thứ " + (i + 1));
            InvoiceDetail detail = new InvoiceDetail();
            detail.inputData(scanner, arrProd, prodIndex);
            this.invoiceDetails[i] = detail;
        }
        calculateTotalAmount();
    }

    public void calculateTotalAmount() {
        this.totalAmount = 0;
        for (InvoiceDetail detail : invoiceDetails) {
            this.totalAmount += detail.getSubTotal();
        }
    }

    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("--------------------------------------------------");
        System.out.printf("Hóa đơn ID: %s | Khách hàng: %s | Ngày: %s\n",
                invoiceId, customerName, sdf.format(invoiceDate));
        System.out.println("Chi tiết hóa đơn:");
        for (InvoiceDetail detail : invoiceDetails) {
            detail.displayData();
        }
        System.out.printf("TỔNG CỘNG: %.2f\n", totalAmount);
        System.out.println("--------------------------------------------------");
    }
}
