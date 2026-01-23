public class CreditCardPayment extends Payment implements Refundable{

    @Override
    void pay() {
        System.out.println("Thanh toán bằng Credit card.");
    }

    @Override
    public void refund() {
        System.out.println("Refund từ Credit card.");
    }
}
