public class Car extends MotorVehicle {
    Car(String brand, int year, int fuelType) {
        super(brand, year, fuelType);
    }
    
    @Override
    public void startEngine() {
        System.out.println("The car engine is starting with a smooth purr!");
    }

    public void openTrunk() {
        System.out.println("The car trunk is now open.");
    }
  
}
