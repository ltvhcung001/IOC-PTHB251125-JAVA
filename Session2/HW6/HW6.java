import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap N = ");
        int n = sc.nextInt();
        while (n <= 0){
            System.out.println("So nhap vao khong hop le, nhap so nguyen duong.");
            System.out.print("Nhap N = ");
            n = sc.nextInt();
        }

        for(int i = 0; i <= n; i++){
            int cnt = 0;
            int temp = i;
            while(temp > 0){
                cnt++;
                temp /= 10;
            }
            temp = i;

            int sum = 0;
            while(temp > 0){
                int digit = temp % 10;
                int factor = 1;
                for (int j = 0; j < cnt; j++){
                    factor *= digit;
                }
                sum += factor;
                temp /= 10;
            }
            if (sum == i) System.out.printf("%d ", i);    
        }
        sc.close();
    }
}
