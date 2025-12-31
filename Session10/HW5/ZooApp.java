
import java.util.Scanner;


public class ZooApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println("==================== ZOO MANAGEMENT MENU ====================");
            System.out.println("1. Tạo đối tượng và hiển thị thông tin (Kế thừa + super)");
            System.out.println("2. Kiểm tra Overriding: gọi makeSound() của từng con vật");
            System.out.println("3. Kiểm tra Overloading; gọi eat() và eat(String)");
            System.out.println("4. Kiểm tra đa hình runtime (Animal array)");
            System.out.println("5. Gọi phương thức đặc trưng của từng loài");
            System.out.println("0. Thoát");
            System.out.println("=============================================================");
            System.out.println("Lựa chọn của bạn: ");
            String temp = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }
            switch (choice) {
                case 0 -> {
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break OUTER;
                }
                case 1 -> {
                    Animal animal = new Animal("Generic Animal", 5);
                    Dog dog = new Dog("Buddy", 3, true);
                    Cat cat = new Cat("Whiskers", 2, true);
                    Elephant elephant = new Elephant("Dumbo", 10, false);
                    animal.showInfo();
                    dog.showInfo();
                    cat.showInfo();
                    elephant.showInfo();
                    System.out.println("Bạn đã chọn tạo đối tượng và hiển thị thông tin.");
                }
                case 2 -> {
                    Animal dog = new Dog("Buddy", 3, true);
                    Animal cat = new Cat("Whiskers", 2, true);
                    Animal elephant = new Elephant("Dumbo", 10, false);
                    dog.makeSound();
                    cat.makeSound();
                    elephant.makeSound();
                    System.out.println("Bạn đã chọn kiểm tra Overriding.");
                }
                case 3 -> {
                    Dog dog = new Dog("Buddy", 3, true);
                    Cat cat = new Cat("Whiskers", 2, true);
                    Elephant elephant = new Elephant("Dumbo", 10, false);
                    dog.eat();
                    dog.eat("dog food");
                    cat.eat();
                    cat.eat("cat food");
                    elephant.eat();
                    elephant.eat("elephant food");
                    System.out.println("Bạn đã chọn kiểm tra Overloading.");
                }
                case 4 -> {
                    Animal[] animals = {
                        new Dog("Buddy", 3, true),
                        new Cat("Whiskers", 2, true),
                        new Elephant("Dumbo", 10, false)
                    };
                    for (Animal a : animals) {
                        a.makeSound();
                    }
                    System.out.println("Bạn đã chọn kiểm tra đa hình runtime.");
                }
                case 5 -> {
                    Dog dog = new Dog("Buddy", 3, true);
                    Cat cat = new Cat("Whiskers", 2, true);
                    Elephant elephant = new Elephant("Dumbo", 10, false);
                    dog.fetchBall();
                    cat.climbTree();
                    elephant.sprayWater();
                    System.out.println("Bạn đã chọn gọi phương thức đặc trưng của từng loài.");
                }
                default -> {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    continue;
                }
            }
        }

        
        
        
    }
}
