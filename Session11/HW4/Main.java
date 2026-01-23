public class Main {
    public static void main(String[] args) {
        Device[] devices = new Device[3];
        devices[0] = new Laptop(1, "Laptop");
        devices[1] = new SmartPhone(2, "Điện thoại thông minh");
        devices[2] = new Television(3, "Tivi");

        System.out.println("Quản lý thiết bị: ");
        for (Device device : devices) {
            device.turnOn();
            device.turnOff();
            if (device instanceof Connectable connectable)
                connectable.connectWifi();
            if (device instanceof Chargeable chargeable)
                chargeable.charge();
        }
    }
}
