import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++){
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (arr[i] < arr[j]){
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                }
            }
        }

        System.out.println("Mảng sau khi sắp xếp giảm dần: ");
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
