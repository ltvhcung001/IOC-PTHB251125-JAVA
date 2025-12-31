
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Car car1 = new Car("Toyota", 2025, 1);
        Motorcycle moto1 = new Motorcycle("Honda", 2025, 2);
        Truck truck1 = new Truck("Ford", 2025, 3);
        ArrayList<Vehicle> vehicles = new ArrayList<>();


        while (true) { 
            System.out.println("================== VEHICLE MANGEMENT MENU ==================");
            System.out.println("1. Hiển thị thông tin tất cả phương tiện");
            System.out.println("2. Kiểm tra Overriding: startEngine()");
            System.out.println("3. Kiểm tra Overloading: move()");
            System.out.println("4. Kiểm tra đa hình runtime (mảng Vehicle[])");
            System.out.println("5. Gọi các hành vi đặc biệt theo từng loại");
            System.out.println("6. Thêm phương tiện mới");
            System.out.println("0. Thoát chương trình");
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
                case 1 -> {
                    System.out.println("Thông tin tất cả phương tiện:");
                    car1.showInfo();
                    moto1.showInfo();
                    truck1.showInfo();
                }
                case 2 -> {
                    System.out.println("Kiểm tra Overriding:");
                    car1.startEngine();
                    moto1.startEngine();
                    truck1.startEngine();
                }
                case 3 -> {
                    System.out.println("Kiểm tra Overloading:");
                    car1.move();
                    car1.move(80);
                }
                case 4 -> {
                    System.out.println("Đa hình runtime với mảng Vehicle[]:");
                    Vehicle[] vehicleArray = {car1, moto1, truck1};
                    for (Vehicle v : vehicleArray) {
                        v.startEngine();
                    }
                }
                case 5 -> {
                    System.out.println("Gọi các hành vi đặc biệt:");
                    moto1.doWheelie();
                    truck1.loadCargo();
                }
                case 6 -> {
                    System.out.println("Thêm phương tiện mới:");
                    System.out.println("Chọn loại phương tiện (1: Car, 2: Motorcycle, 3: Truck): ");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập hãng sản xuất: ");
                    String make = sc.nextLine();
                    System.out.println("Nhập năm sản xuất: ");
                    int year = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập ID phương tiện: ");
                    int id = Integer.parseInt(sc.nextLine());

                    Vehicle newVehicle;
                    switch (type) {
                        case 1 -> newVehicle = new Car(make, year, id);
                        case 2 -> newVehicle = new Motorcycle(make, year, id);
                        case 3 -> newVehicle = new Truck(make, year, id);
                        default -> {
                            System.out.println("Loại phương tiện không hợp lệ.");
                            continue;
                        }
                    }
                    vehicles.add(newVehicle);
                    System.out.println("Phương tiện mới đã được thêm:");
                    newVehicle.showInfo();
                }
                case 0 -> {
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        
            }
        }
    }
}
