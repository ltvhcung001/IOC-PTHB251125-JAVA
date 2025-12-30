public class HW3 {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 20, 3.5);
        Student student2 = new Student("Bob", 22, 3.8);
        Student student3 = new Student("Charlie", 19, 3.2);
        System.out.println("Thông tin sinh viên 1:");
        student1.printInfo();
        System.out.println("Thông tin sinh viên 2:");
        student2.printInfo();
        System.out.println("Thông tin sinh viên 3:");
        student3.printInfo();

        System.out.println("Tổng số sinh viên: " + Student.count);
    }
}
