import java.util.Scanner;

public class HW5 {
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
        System.out.print("Nhap so luong sinh vien (n): ");
        int n = sc.nextInt();
        double[] a = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap diem sinh vien " + (i + 1) + ": ");
            a[i] = sc.nextDouble();
        }

        while (true) {
            System.out.println("--- QUAN LY DIEM SINH VIEN ---");
            System.out.println("1. Xem tat ca diem");
            System.out.println("2. Sap xep diem");
            System.out.println("3. Tim kiem diem");
            System.out.println("4. Thong ke diem");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Danh sach diem: ");
                for (int i = 0; i < n; i++) {
                    System.out.printf("Sinh vien %d: %.1f\n", i + 1, a[i]);
                }
            } else if (choice == 2) {
                System.out.println("1. Tang dan");
                System.out.println("2. Giam dan");
                int choice2 = sc.nextInt();
                if (choice2 == 1) {
                    sort(a, true);
                    System.out.println("Da sap xep tang dan");
                } else if (choice2 == 2) {
                    sort(a, false);
                    System.out.println("Da sap xep giam dan");
                }
            } else if (choice == 3) {
                System.out.print("Nhap so diem can tim: ");
                double point = sc.nextDouble();
                System.out.print("Tim kiem tuyen tinh: ");
                sort(a, true);
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (a[i] == point) {
                        System.out.println("Tim thay tai vi tri " + i);
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    System.out.println("Khong tim thay diem " + point + " trong mang.");

                System.out.print("Tim kiem nhi phan (mang tang dan): ");
                int index = binarySearch(a, point, 0, n - 1);
                if (index == -1)
                    System.out.println("Khong tim thay diem " + point + " trong mang.");
                else
                    System.out.print("Tim thay tai vi tri " + index);
            } else if (choice == 4) {
                double max_point = a[0];
                double min_point = a[0];
                double sum = 0.0;
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    max_point = Double.max(max_point, a[i]);
                    min_point = Double.min(min_point, a[i]);
                    sum += a[i];
                }
                for (int i = 0; i < n; i++)
                    if (a[i] > (sum / n)) cnt++;
                System.out.println("Diem trung binh: " + (sum / n));
                System.out.println("Diem cao nhat: " + max_point);
                System.out.println("Diem thap nhat: " + min_point);
                System.out.println("So sinh vien co diem tren trung binh: " + cnt);
            } else if (choice == 5) {
                sc.close();
                System.out.println("Thoat chuong trinh.");
                return;
            } else
                System.out.println("Lua chon khong hop le, vui long chon lai!");
        }

    }
}
