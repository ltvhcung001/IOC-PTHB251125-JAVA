public class MotorVehicle extends Vehicle{
    private int fuelType; // 1 for petrol, 2 for diesel, 3 for electric

    public MotorVehicle(String name, int year, int fuelType) {
        super(name, year);
        this.fuelType = fuelType;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        String fuel;
        fuel = switch (fuelType) {
            case 1 -> "Petrol";
            case 2 -> "Diesel";
            case 3 -> "Electric";
            default -> "Unknown";
        };
        System.out.println("Fuel Type: " + fuel);
    }
}