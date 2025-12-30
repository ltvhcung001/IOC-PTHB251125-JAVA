import java.util.Scanner;

public class HW3 {
    public static int binarySearch(int[] arr, int key, int left, int right){
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == key) return mid;
        else if (arr[mid] > key) return binarySearch(arr, key, mid + 1, right);
        else if (arr[mid] < key) return binarySearch(arr, key, left, mid - 1);      
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }
        System.out.println("Mảng sau khi sắp xếp giảm dần: ");

        // Selection sort
        for (int i = 0; i < n; i++){
            int maxElementIndex = i;
            for (int j = i + 1; j < n; j++){
                if (a[maxElementIndex] < a[j]){
                    maxElementIndex = j;
                }
            }
            if (maxElementIndex != i){
                a[maxElementIndex] ^= a[i];
                a[i] ^= a[maxElementIndex];
                a[maxElementIndex] ^= a[i];
            }
        }
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.print("\nNhập số cần tìm: ");
        int k = sc.nextInt();

        // Linear search
        boolean flag = false;
        System.out.print("Tìm kiếm tuyến tính: ");
        for (int i = 0; i < n; i++){
            if (a[i] == k){
                System.out.print("Số " + k + " có tại vị trí " + i);
                flag = true;
            }
        }
        if (!flag) System.out.print("Không tìm thấy số " + k + " trong mảng."); 
        System.out.println();

        // Binary search
        System.out.print("Tìm kiếm nhị phân: ");
        int index = binarySearch(a, k, 0, n-1);
        if (index == -1) System.out.print("Không tìm thấy số " + k + " trong mảng.");
        else System.out.print("Số " + k + " có tại vị trí " + index);
        
        sc.close();
    }
}
