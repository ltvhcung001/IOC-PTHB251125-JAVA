package ra.entity;

import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private Role role;
    private double salary;

    public Employee() {}

    // Getter & Setter
    public String getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public Role getRole() { return role; }
    public double getSalary() { return salary; }

    public void inputData(Scanner scanner, Employee[] arrEmp, int index) {
        // Nhập ID với kiểm tra trùng (giữ nguyên như phần trước)
        while (true) {
            System.out.print("Nhập mã nhân viên (E + 4 ký tự): ");
            this.employeeId = scanner.nextLine();
            if (this.employeeId.matches("^E.{4}$")) {
                boolean isExist = false;
                for (int i = 0; i < index; i++) {
                    if (arrEmp[i].getEmployeeId().equals(this.employeeId)) {
                        isExist = true; break;
                    }
                }
                if (!isExist) break;
                else System.err.println("Mã nhân viên đã tồn tại!");
            } else System.err.println("Mã không đúng định dạng!");
        }
        inputUpdate(scanner);
    }

    public void inputUpdate(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên nhân viên (6-30 ký tự): ");
            this.employeeName = scanner.nextLine();
            if (this.employeeName.length() >= 6 && this.employeeName.length() <= 30) break;
            else System.err.println("Tên phải từ 6-30 ký tự!");
        }
        while (true) {
            System.out.print("Chọn chức vụ (1.DEV, 2.TESTER, 3.PM, 4.BA): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: this.role = Role.DEV; break;
                    case 2: this.role = Role.TESTER; break;
                    case 3: this.role = Role.PM; break;
                    case 4: this.role = Role.BA; break;
                    default: throw new Exception();
                }
                break;
            } catch (Exception e) { System.err.println("Chọn sai, vui lòng nhập 1-4!"); }
        }
        while (true) {
            System.out.print("Nhập lương (> 0): ");
            try {
                this.salary = Double.parseDouble(scanner.nextLine());
                if (this.salary > 0) break;
                else System.err.println("Lương > 0!");
            } catch (Exception e) { System.err.println("Nhập số!"); }
        }
    }

    public void displayData() {
        System.out.printf("| %-8s | %-25s | %-10s | %,15.2f |\n",
                employeeId, employeeName, role, salary);
    }
}