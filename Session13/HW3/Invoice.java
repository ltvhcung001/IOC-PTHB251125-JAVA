public class Invoice {
    private int id;
    private String code;
    private double amount;

    public Invoice(int id, String code, double amount) {
        this.id = id;
        this.code = code;
        this.amount = amount;
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "ID : " + id + " , Mã hóa đơn: " + code + ", Số tiền: " + amount;
    }
}