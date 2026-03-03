import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management mgmt = new Management();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- QUẢN LÝ NHÂN VIÊN & DỰ ÁN ---");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Thêm dự án");
            System.out.println("3. Gán nhân viên vào dự án");
            System.out.println("4. Hiển thị danh sách phân công");
            System.out.println("5. Cập nhật lương nhân viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Tên NV: "); String name = sc.nextLine();
                    System.out.print("Phòng ban: "); String dept = sc.nextLine();
                    System.out.print("Lương: "); double salary = sc.nextDouble();
                    mgmt.addEmployee(new Employee(0, name, dept, salary));
                    break;
                case 2:
                    System.out.print("Tên dự án: "); String pName = sc.nextLine();
                    System.out.print("Ngân sách: "); double budget = sc.nextDouble();
                    mgmt.addProject(new Project(0, pName, budget));
                    break;
                case 3:
                    System.out.print("ID Nhân viên: "); int eid = sc.nextInt();
                    System.out.print("ID Dự án: "); int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Vai trò: "); String role = sc.nextLine();
                    mgmt.assignEmployeeToProject(eid, pid, role);
                    break;
                case 4:
                    mgmt.listEmployeesAndProjects();
                    break;
                case 5:
                    System.out.print("ID Nhân viên: "); int uid = sc.nextInt();
                    System.out.print("Lương mới: "); double nSalary = sc.nextDouble();
                    mgmt.updateEmployeeSalary(uid, nSalary);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}