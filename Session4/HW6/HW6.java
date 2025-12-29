import java.util.Scanner;

public class HW6 {
    public static void sort(double[] a, boolean asc) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (asc ? a[i] > a[j] : a[i] < a[j]) {
                    double temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static int binarySearch(double[] a, double key, int left, int right) {
        if (left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if (a[mid] == key)
            return mid;
        else if (a[mid] < key)
            return binarySearch(a, key, mid + 1, right);
        else if (a[mid] > key)
            return binarySearch(a, key, left, mid - 1);
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap luong nhan vien " + (i + 1) + ": ");
            a[i] = sc.nextDouble();
        }

        while (true) {
            System.out.println("--- QUAN LI LUONG NHAN VIEN ---");
            System.out.println("1. Xem danh sach luong");
            System.out.println("2. Sap xep luong");
            System.out.println("3. Tim kiem luong");
            System.out.println("4. Thong ke luong");
            System.out.println("5. Thoat");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Danh sach luong nhan vien: ");
                for (int i = 0; i < n; i++) {
                    System.out.printf("Nhan vien %d: %s\n", i + 1, a[i]);
                }
            } else if (choice == 2) {
                System.out.println("Chon cach sap xep: ");
                System.out.println("1. Tang dan");
                System.out.println("2. Giam dan");
                int choice2 = sc.nextInt();
                if (choice2 == 1) {
                    sort(a, true);
                    System.out.println("Da sap xep luong tang dan.");
                } else if (choice == 2) {
                    sort(a, false);
                    System.out.println("Da sap xep luong giam dan.");
                }
            } else if (choice == 3) {
                sort(a, true);
                System.out.print("Nhap luong can tim: ");
                double salary = sc.nextDouble();

                System.out.print("Linear Search: ");
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (a[i] == salary) {
                        System.out.println("Tim thay luong " + salary + " tai vi tri " + i);
                        flag = true;
                        break;
                    }
                }

                if (!flag)
                    System.out.println("Khong tim thay.");

                System.out.print("Binary Search (mang tang dan): ");

                int index = binarySearch(a, salary, 0, n - 1);
                if (index == -1)
                        System.out.println("Khong tim thay.");
                    else
                        System.out.println("Tim thay luong " + salary + " tai vi tri " + index);
            } else if (choice == 4) {
                double sum = 0.0;
                double max_salary = a[0];
                double min_salary = a[0];
                int cnt = 0;
                for (int i = 0; i < n;i++){
                    sum += a[i];
                    min_salary = Double.min(min_salary, a[i]);
                    max_salary = Double.max(max_salary, a[i]);
                }

                for (int i = 0; i < n; i++)
                    if (a[i] > (sum / n)) cnt++;
                System.out.println("Tong luong: " + sum);
                System.out.println("Luong trung binh: " + (sum / n));
                System.out.println("Luong cao nhat: " + max_salary);
                System.out.println("Luong thap nhat: " + min_salary);
                System.out.println("So nhan vien co luong tren trung binh: " + cnt);
            } else if (choice == 5) {
                sc.close();
                System.out.println("Thoat chuong trinh.");
                return;
            } else
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
        }
    }
}
