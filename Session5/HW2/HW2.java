
public class HW2 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        String str = "Hello";
        for (int i = 0; i < 1_000_000; i++){
            str = str + "Word";
        }
        long stringTime = System.nanoTime() - start;
        System.out.println("Thoi gian thuc hien voi String: " + stringTime / 1_000_000 + " ms");
        
        start = System.nanoTime();

        StringBuilder sb1 = new StringBuilder("Hello");
        for (int i = 0; i < 1_000_000; i++){
            sb1.append("World");
        }
        stringTime = System.nanoTime() - start;
        System.out.println("Thoi gian thuc hien voi StringBuilder: " + stringTime / 1_000_000 + " ms");
        
        start = System.nanoTime();
        StringBuffer sb2 = new StringBuffer("Hello");
        for (int i = 0; i < 1_000_000; i++){
            sb2.append("World");
        }
        stringTime = System.nanoTime() - start;
        System.out.println("Thoi gian thuc hien voi StringBuffer: " + stringTime / 1_000_000 + " ms");
        
        System.out.println("Nhan xet: ");
        System.out.println("- String: Khong hieu qua cho phep noi chuoi nhieu lan do tao ra nhieu doi tuong moi.");
        System.out.println("- StringBuilder: Hieu qua va nhanh chong, thich hop cho nhieu thao tac noi chuoi trong mot luong.");
        System.out.println("- StringBuffer: Tuong tu nhu StringBuilder nhung an toan hon voi da luong, co the cham hon mot chut do dong bo hoa.");
    }    
}
