
public class Car {
    private int currentSpeed = 0;

    public void accelerate() {
        currentSpeed += 10;
        System.out.println("Car accelerates by default: " + currentSpeed + " km/h");
    }

    public void accelerate(int speed) {
        currentSpeed += speed;
        System.out.println("Car accelerates by " + currentSpeed + " km/h"); 
    }

    public void accelerate(int speed, int seconds) {
        int increase = speed * seconds;
        currentSpeed += increase;
        System.out.println("car accelerates " + increase + " km/h (speed x time)");
    }

    public void printStatus() {
        System.out.println("Current Speed: " + currentSpeed + " km/h");
    }
}
