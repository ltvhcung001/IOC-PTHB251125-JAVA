
public class HW3 {
    public static void main(String[] args) {
        Computer comp = new Computer();

        double price1 = comp.calculatePrice(1000);
        System.out.println("Final Price: " + price1 + "\n");

        double price2 = comp.calculatePrice(1000, 10);
        System.out.println("Final Price: " + price2 + "\n");

        double price3 = comp.calculatePrice(1000, 10, 5);
        System.out.println("Final Price: " + price3 + "\n");
    }
}
