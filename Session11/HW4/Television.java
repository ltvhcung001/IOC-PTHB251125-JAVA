public class Television extends Device implements Connectable{

    

    public Television(int id, String name) {
        super(id, name);
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
