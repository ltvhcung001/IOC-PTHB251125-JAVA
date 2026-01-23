class Main{
    public static void main(String[] args){
        Payment[] payments = new Payment[3];
        payments[0] = new CashPayment();
        payments[1] = new CreditCardPayment();
        payments[2] = new EWalletPayment();

        for (Payment payment : payments){
            payment.pay();
            if (payment instanceof Refundable)
                ((Refundable) payment).refund();
        }
    }
}