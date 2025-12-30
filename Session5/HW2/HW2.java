
public class HW2 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        String str = "Hello";
        for (int i = 0; i < 1_000_000; i++){
            str = str + "Word";
        }
        long stringTime = System.nanoTime() - start;
        System.out.println("Thời gian thực hiện với String: " + stringTime / 1_000_000 + " ms");
        
        start = System.nanoTime();

        StringBuilder sb1 = new StringBuilder("Hello");
        for (int i = 0; i < 1_000_000; i++){
            sb1.append("World");
        }
        stringTime = System.nanoTime() - start;
        System.out.println("Thời gian thực hiện với StringBuilder: " + stringTime / 1_000_000 + " ms");
        
        start = System.nanoTime();
        StringBuffer sb2 = new StringBuffer("Hello");
        for (int i = 0; i < 1_000_000; i++){
            sb2.append("World");
        }
        stringTime = System.nanoTime() - start;
        System.out.println("Thời gian thực hiện với StringBuffer: " + stringTime / 1_000_000 + " ms");
        
        System.out.println("Nhận xét: "); 
        System.out.println("- String: Không hiệu quả cho phép nối chuỗi nhiều lần do tạo ra nhiều đối tượng mới.");
        System.out.println("- StringBuilder: Hiệu quả và nhanh chóng, thích hợp cho nhiều thao tác nối chuỗi trong một luồng.");
        System.out.println("- StringBuffer: Tương tự như StringBuilder nhưng an toàn hơn với đa luồng, có thể chậm hơn một chút do đông bộ hóa.");
    }    
    
}
