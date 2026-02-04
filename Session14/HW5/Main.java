import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        accounts.add(new BankAccount("VCB001", 1000000));
        accounts.add(new BankAccount("ACB002", 500000));
        
        System.out.println("--- Danh sách tài khoản ban đầu ---");
        displayAllAccounts();

        try {
            System.out.println("\n[Giao dịch: Gửi tiền]");
            BankAccount acc1 = findAccount("VCB001");
            if (acc1 != null) acc1.deposit(200000);

            System.out.println("\n[Giao dịch: Rút tiền]");
            BankAccount acc2 = findAccount("ACB002");
            if (acc2 != null) acc2.withdraw(100000);

            System.out.println("\n[Giao dịch: Chuyển tiền]");
            BankAccount source = findAccount("VCB001");
            BankAccount target = findAccount("ACB002");
            if (source != null && target != null) {
                source.transfer(target, 300000);
            }
            System.out.println("\n[Giao dịch: Chuyển tiền quá số dư]");
            source.transfer(target, 5000000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Danh sách tài khoản sau giao dịch ---");
        displayAllAccounts();
    }

    public static BankAccount findAccount(String id) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountId().equalsIgnoreCase(id)) {
                return acc;
            }
        }
        System.out.println("Lỗi: Không tìm thấy số tài khoản " + id);
        return null;
    }

    public static void displayAllAccounts() {
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
    }
}