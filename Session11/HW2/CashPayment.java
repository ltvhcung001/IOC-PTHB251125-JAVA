public class CashPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Thanh toán bằng tiền mặt.");
    }
}
