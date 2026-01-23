public class EWalletPayment extends Payment implements Refundable{

    @Override
    void pay() {
        System.out.println("Thanh toán bằng ví điện tử.");
    }

    @Override
    public void refund() {
        System.out.println("Refund tiền từ ví điện tử");
    }
}
