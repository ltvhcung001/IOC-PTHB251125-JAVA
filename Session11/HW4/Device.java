public abstract class Device {
    int id;
    String name;

    public Device(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    abstract void turnOn();
    abstract void turnOff();
}
