
public class Computer {
    double calculatePrice(double basePrice){
        System.out.println("[Using basePrice only]");
        return basePrice;
    }
    double calculatePrice(double basePrice, double tax){
        System.out.println("[Using basePrice + tax]");
        return basePrice + (basePrice * tax / 100);
    }
    double calculatePrice(double basePrice, double tax, double discount){
        System.out.println("[Using basePrice + tax + discount]");
        double priceWithTax = basePrice + (basePrice * tax / 100);
        return priceWithTax - (priceWithTax * discount / 100);
    }
}
