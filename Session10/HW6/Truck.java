public class Truck extends MotorVehicle {
    Truck(String brand, int year, int fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine() {
        System.out.println("The truck engine is starting with a deep rumble!");
    }

    public void loadCargo() {
        System.out.println("The truck is loading cargo.");
    }
}
