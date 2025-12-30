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
        System.out.println("ID cua khach hang: " + id);
        System.out.println("Ten khach hang: "+ name);
        System.out.println("Email khach hang: " + email);
    }
}
