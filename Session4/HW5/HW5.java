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
        System.out.print("Nhập số lượng sinh viên (n): ");
        int n = sc.nextInt();
        double[] a = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập điểm sinh viên " + (i + 1) + ": ");
            a[i] = sc.nextDouble();
        }

        while (true) {
            System.out.println("--- QUẢN LÝ ĐIỂM SINH VIÊN ---");
            System.out.println("1. Xem tất cả điểm");
            System.out.println("2. Sắp xếp điểm");
            System.out.println("3. Tìm kiếm điểm");
            System.out.println("4. Thống kê điểm");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Danh sách điểm: ");
                for (int i = 0; i < n; i++) {
                    System.out.printf("Sinh viên %d: %.1f\n", i + 1, a[i]);
                }
            } else if (choice == 2) {
                System.out.println("1. Tăng dần");
                System.out.println("2. Giảm dần");
                int choice2 = sc.nextInt();
                if (choice2 == 1) {
                    sort(a, true);
                    System.out.println("Đã sắp xếp tăng dần");
                } else if (choice2 == 2) {
                    sort(a, false);
                    System.out.println("Đã sắp xếp giảm dần");
                }
            } else if (choice == 3) {
                System.out.print("Nhập số cần tìm: ");
                double point = sc.nextDouble();
                System.out.print("Tìm kiếm tuyến tính: ");
                sort(a, true);
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (a[i] == point) {
                        System.out.println("Tìm thấy tại vị trí " + i);
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    System.out.println("Không tìm thấy điểm " + point + " trong mảng.");

                System.out.print("Tìm kiếm nhị phân (mảng tăng dần): ");
                int index = binarySearch(a, point, 0, n - 1);
                if (index == -1)
                    System.out.println("Không tìm thấy điểm " + point + " trong mảng.");
                else
                    System.out.print("Tìm thấy tại vị trí " + index);
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
                System.out.println("Điểm trung bình: " + (sum / n));
                System.out.println("Điểm cao nhất: " + max_point);
                System.out.println("Điểm thấp nhất: " + min_point);
                System.out.println("Số sinh viên có điểm trên trung bình: " + cnt);
            } else if (choice == 5) {
                sc.close();
                System.out.println("Thoát chương trình.");
                return;
            } else
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
        }

    }
}
