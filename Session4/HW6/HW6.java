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
        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập lương nhân viên thứ " + (i + 1) + ": ");
            a[i] = sc.nextDouble();
        }

        while (true) {
            System.out.println("--- QUẢN LÝ LƯƠNG NHÂN VIÊN ---");
            System.out.println("1. Xem danh sách lương");
            System.out.println("2. Sắp xếp lương");
            System.out.println("3. Tìm kiếm lương");
            System.out.println("4. Thống kê lương");
            System.out.println("5. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Danh sách lương nhân viên: ");
                for (int i = 0; i < n; i++) {
                    System.out.printf("Nhân viên %d: %s\n", i + 1, a[i]);
                }
            } else if (choice == 2) {
                System.out.println("Chọn cách sắp xếp: ");
                System.out.println("1. Tăng dần");
                System.out.println("2. Giảm dần");
                int choice2 = sc.nextInt();
                if (choice2 == 1) {
                    sort(a, true);
                    System.out.println("Đã sắp xếp lương tăng dần.");
                } else if (choice == 2) {
                    sort(a, false);
                    System.out.println("Đã sắp xếp lương giảm dần.");
                }
            } else if (choice == 3) {
                sort(a, true);
                System.out.print("Nhập lương cần tìm: ");
                double salary = sc.nextDouble();

                System.out.print("Linear Search: ");
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (a[i] == salary) {
                        System.out.println("Tìm thấy lương " + salary + " tại vị trí " + i);
                        flag = true;
                        break;
                    }
                }

                if (!flag)
                    System.out.println("Không tìm thấy.");

                System.out.print("Binary Search (mảng tăng dần): ");

                int index = binarySearch(a, salary, 0, n - 1);
                if (index == -1)
                        System.out.println("Không tìm thấy.");
                    else
                        System.out.println("Tìm thấy lương " + salary + " tại vị trí " + index);
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
                System.out.println("Tổng lương: " + sum);
                System.out.println("Lương trung bình: " + (sum / n));
                System.out.println("Lương cao nhất: " + max_salary);
                System.out.println("Lương thấp nhất: " + min_salary);
                System.out.println("Số nhân viên có lương trên trung bình: " + cnt);
            } else if (choice == 5) {
                sc.close();
                System.out.println("Thoát chương trình.");
                return;
            } else
                System.out.println("Lựa chọn của bạn không hợp lệ, vui lòng chọn lại!");
        }
    }
}
