import java.util.Scanner;

class HW1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n = ");
        int n = sc.nextInt();
        if(n > 0){
            int sum = 0;
            for(int i = 0; i <= n; i++){
                sum += i;
            }
            System.out.printf("Tổng các số từ 1 đến %d là: %d", n, sum);
        }
        else{
            System.out.println("Số nhập vào không hợp lệ.");
        }
        sc.close();
    }
}