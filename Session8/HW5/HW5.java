
import java.util.ArrayList;
import java.util.Scanner;


public class HW5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        OUTER:
        while (true) {
            Student st1 = new Student();
            System.out.println("=== MENU SINH VIÊN ===");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm sinh viên có GPA cao nhất");
            System.out.println("4. In tổng số sinh viên đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String temp = sc.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(temp);
            } catch (Exception e) { 
            }
            switch (choice) {
                case 0:
                    sc.close();
                    System.out.println("Thoát chương trình.");
                    break OUTER;
                case 1:
                    do {
                        System.out.println("Nhap thông tin sinh viên:");
                        st1.input(sc);
                        studentList.add(st1);
                        System.out.println("Thông tin sinh viên đã nhập:");
                        st1.print();
                        System.out.println("Bạn có muốn nhập thêm sinh viên không? (y/n): ");
                        String ans = sc.nextLine();
                        if (!ans.equalsIgnoreCase("y")) {
                            break;
                        }
                        st1 = new Student();
                    } while (true);
                    break;
                case 2:
                    System.out.println("Danh sách sinh viên đã nhập:");
                    for (Student st : studentList) {
                        st.print();
                    }
                    break;
                case 3:
                    if (studentList.isEmpty()) {
                        System.out.println("Chưa có sinh viên nào trong danh sách.");
                        break;
                    }
                    double maxGpa = studentList.get(0).getGpa();
                    for (Student st : studentList) {
                        if (st.getGpa() > maxGpa) {
                            maxGpa = st.getGpa();
                        }
                    }
                    System.out.println("Sinh viên có GPA cao nhất:");
                    for (Student st : studentList) {
                        if (st.getGpa() == maxGpa) {
                            st.print();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Tổng số sinh viên đã tạo: " + Student.getTotalStudent());
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
            System.out.println(); 
        }
    }
}
