public abstract class Payment {
    double amount;
    abstract void pay();
    void printAmount(){
        System.out.println("Amount: " + amount);
    }
}
