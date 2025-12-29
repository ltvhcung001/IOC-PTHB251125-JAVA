import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so hang cua mang: ");
        int m = sc.nextInt();
        System.out.print("Nhap so cot cua mang: ");
        int n = sc.nextInt();
        
        int[][] a = new int[m][n];

        long sum_odd = 0L;
        long sum_even = 0L;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print("Nhap phan tu [" + i + "][" + j + "]: ");
                a[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (a[i][j] % 2 == 0) sum_even += a[i][j];
                else sum_odd += a[i][j];
            }
        }
        
        System.out.println("Tong cac so chan: " + sum_even);
        System.out.println("Tong cac so le: " + sum_odd);
        sc.close();
    }
}
