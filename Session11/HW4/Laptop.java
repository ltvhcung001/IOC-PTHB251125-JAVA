public class Laptop extends Device implements Connectable, Chargeable{

    public Laptop(int id, String name) {
        super(id, name);
    }

    @Override
    public void charge() {
        System.out.println("Đang sạc thiết bị: " + name + ", với id: " + id);
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " đang kết nối wifi.");
    }

    @Override
    void turnOn() {
        System.out.println(name + " đang bật.");
    }

    @Override
    void turnOff() {
        System.out.println(name + " đang tắt.");
    }

}
