public class Customer {
    public int id;
    public String name;
    public String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void showInfo(){
        System.out.println("ID khách hàng: " + id);
        System.out.println("Tên khách hàng: "+ name);
        System.out.println("Email khách hàng: " + email);
    }
}
