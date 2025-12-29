import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.err.println("Mang khong co phan tu.");
            return;
        }
        int[] a = new int[n];
        System.out.println("Nhap cac phan tu cua mang, ngan cach bang dau space: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0)
                continue;
            for (int j = i + 1; j < n; j++) {
                if (a[j] % 2 == 0) {
                    a[i] ^= a[j];
                    a[j] ^= a[i];
                    a[i] ^= a[j];
                    break;
                }
            }
        }

        System.out.println("Mang sau khi duoc sap xep: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        sc.close();
    }
}
