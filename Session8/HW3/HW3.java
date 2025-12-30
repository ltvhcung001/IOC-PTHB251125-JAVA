
public class HW3 {
    public static void main(String[] args) {
        CurrencyConverter.setRate(25300);

        int tienVND = 1000000; 

        double ketQuaUSD = CurrencyConverter.toUSD(tienVND);

        System.out.println("--- KẾT QUẢ ---");
        System.out.println("Số tiền VND: " + tienVND);
        
        System.out.println("Số tiền USD (gốc): " + ketQuaUSD);
        System.out.println("Số tiền USD (làm tròn): " + CurrencyConverter.formatUSD(ketQuaUSD, 2) + " $");
    }
}