
public class Motorcycle extends MotorVehicle {
    Motorcycle(String brand, int year, int fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine() {
        System.out.println("The motorcycle engine is starting with a roar!");
    }
    
    public void doWheelie() {
        System.out.println("The motorcycle is doing a wheelie!");
    }
}
