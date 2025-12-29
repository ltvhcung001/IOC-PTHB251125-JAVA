import java.util.Random;
import java.util.Scanner;
public class HW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n (1 <= n <= 1000) = ");
        int n = sc.nextInt();
        Random random = new Random();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < n; i++){
            int type = random.nextInt(3); 
            int asciiVal = 0;
            switch (type) {
                case 0: 
                    asciiVal = random.nextInt(57 - 48 + 1) + 48; 
                    break;
                case 1: 
                    asciiVal = random.nextInt(90 - 65 + 1) + 65; 
                    break;
                case 2: 
                    asciiVal = random.nextInt(122 - 97 + 1) + 97; 
                    break;
            }
            sBuffer.append((char) asciiVal);
        }

        System.out.println(sBuffer);

        sc.close();
    }
}
