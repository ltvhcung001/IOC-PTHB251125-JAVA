
public class HW4 {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.accelerate();
        myCar.printStatus();

        myCar.accelerate(30);
        myCar.printStatus();

        myCar.accelerate(20, 3);
        myCar.printStatus();
    }
}
