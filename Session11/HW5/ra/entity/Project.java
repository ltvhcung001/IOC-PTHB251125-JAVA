package ra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project {
    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee[] employees = new Employee[0];
    private ProjectStatus status;

    public Project() {}

    // Getter
    public String getProjectId() { return projectId; }
    public String getProjectName() { return projectName; }
    public Employee[] getEmployees() { return employees; }
    public ProjectStatus getStatus() { return status; }
    public LocalDate getEndDate() { return endDate; }

    public void inputData(Scanner scanner, Project[] arrProject, int index) {
        while (true) {
            System.out.print("Nhập mã dự án (P + 4 ký tự): ");
            this.projectId = scanner.nextLine();
            if (this.projectId.matches("^P.{4}$")) break;
            else System.err.println("Mã sai định dạng!");
        }
        inputUpdate(scanner, arrProject, index);
    }

    public void inputUpdate(Scanner scanner, Project[] arrProject, int index) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhập tên dự án (10-50 ký tự, duy nhất): ");
            this.projectName = scanner.nextLine();
            boolean isExist = false;
            for (int i = 0; i < index; i++) {
                if (arrProject[i] != this && arrProject[i].getProjectName().equalsIgnoreCase(this.projectName)) {
                    isExist = true; break;
                }
            }
            if (!isExist && projectName.length() >= 10 && projectName.length() <= 50) break;
            else System.err.println("Tên không hợp lệ hoặc đã tồn tại!");
        }
        while (true) {
            try {
                System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
                this.startDate = LocalDate.parse(scanner.nextLine(), dtf);
                System.out.print("Nhập ngày kết thúc (dd/MM/yyyy): ");
                this.endDate = LocalDate.parse(scanner.nextLine(), dtf);
                if (!endDate.isBefore(startDate)) break;
                else System.err.println("Ngày kết thúc phải >= ngày bắt đầu!");
            } catch (Exception e) { System.err.println("Sai định dạng ngày!"); }
        }
        while (true) {
            System.out.print("Chọn trạng thái (1.PLANNING, 2.RUNNING, 3.FINISHED): ");
            try {
                int c = Integer.parseInt(scanner.nextLine());
                if (c==1) status = ProjectStatus.PLANNING;
                else if (c==2) status = ProjectStatus.RUNNING;
                else if (c==3) status = ProjectStatus.FINISHED;
                else throw new Exception();
                break;
            } catch (Exception e) { System.err.println("Chọn 1-3!"); }
        }
    }

    public void addEmployeeToProject(Employee emp) {
        Employee[] newArr = new Employee[this.employees.length + 1];
        System.arraycopy(this.employees, 0, newArr, 0, this.employees.length);
        newArr[this.employees.length] = emp;
        this.employees = newArr;
    }

    public void displayData() {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("DỰ ÁN: [%s] %s | TRẠNG THÁI: %s\n", projectId, projectName, status);
        System.out.printf("Thời gian: %s - %s | Số NV: %d\n", startDate, endDate, employees.length);
        System.out.println("Danh sách nhân viên dự án: ");
        for (Employee e : employees) e.displayData();
    }
}