import java.util.Scanner;

class HW1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n = ");
        int n = sc.nextInt();
        if(n > 0){
            int sum = 0;
            for(int i = 0; i <= n; i++){
                sum += i;
            }
            System.out.printf("Tong cac so tu 1 den %d la: %d", n, sum);
        }
        else{
            System.out.println("So nhap vao khong hop le.");
        }
        
        sc.close();
    }
}