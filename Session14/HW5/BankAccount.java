public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Lỗi: Số tiền gửi phải lớn hơn 0!");
        }
        this.balance += amount;
        System.out.println("Đã gửi " + amount + " vào tài khoản " + accountId);
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Lỗi: Số tiền rút phải lớn hơn 0!");
        }
        if (amount > this.balance) {
            throw new Exception("Lỗi: Số dư không đủ để thực hiện giao dịch rút tiền!");
        }
        this.balance -= amount;
        System.out.println("Đã rút " + amount + " từ tài khoản " + accountId);
    }

    public void transfer(BankAccount targetAccount, double amount) throws Exception {
        if (targetAccount == null) {
            throw new Exception("Lỗi: Tài khoản đích không tồn tại!");
        }
        if (amount <= 0) {
            throw new Exception("Lỗi: Số tiền chuyển phải lớn hơn 0!");
        }
        if (amount > this.balance) {
            throw new Exception("Lỗi: Tài khoản nguồn không đủ số dư để chuyển!");
        }

        this.withdraw(amount); 
        targetAccount.deposit(amount); 
        System.out.println("Giao dịch chuyển tiền thành công!");
    }

    @Override
    public String toString() {
        return "Tài khoản: " + accountId + " | Số dư: " + balance + " VNĐ";
    }
}