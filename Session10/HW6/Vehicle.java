public class Vehicle{
    private String brand;
    private int year;

    public Vehicle() {
    }

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void showInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }

    public void startEngine() {
        System.out.println("The engine of the " + brand + " is starting.");
    }

    public void move(){
        System.out.println("Vehicle is moving.");
    }

    public void move(int speed){
        System.out.println("Vehicle is moving at speed: " + speed + " km/h.");
    }
}