public class Order {
    public int orderID;
    public Customer customer;
    double total;

    public Order(int orderID, Customer customer, double total) {
        this.orderID = orderID;
        this.customer = customer;
        this.total = total;
    }

    public void printOrder(){
        System.out.println("OrderID: " + orderID);
        System.out.println("Customer ID: " + customer.id);
        System.out.println("Customer name: " + customer.name);
        System.out.println("Customer email: " + customer.email);
        System.out.println("Total: " + total);
    }
    
}
