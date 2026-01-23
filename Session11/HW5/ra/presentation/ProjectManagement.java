package ra.presentation;

import ra.entity.*;
import java.time.LocalDate;
import java.util.Scanner;

public class ProjectManagement {
    private static Employee[] arrEmp = new Employee[100];
    private static int empCount = 0;
    private static Project[] arrPro = new Project[100];
    private static int proCount = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== QUẢN LÝ HỆ THỐNG ==========");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý dự án");
            System.out.println("3. Thoát chương trình");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: menuEmployee(); break;
                case 2: menuProject(); break;
                case 3: System.exit(0);
            }
        }
    }

    private static void menuEmployee() {
        while (true) {
            System.out.println("\n================ QUẢN LÝ NHÂN VIÊN ================");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Cập nhật thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên theo tên");
            System.out.println("6. Sắp xếp nhân viên theo lương giảm dần");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 7) break;
            switch (choice) {
                case 1:
                    Employee e = new Employee();
                    e.inputData(sc, arrEmp, empCount);
                    arrEmp[empCount++] = e;
                    break;
                case 2:
                    showEmployeeList();
//                    for (int i = 0; i < empCount; i++) arrEmp[i].displayData();
                    break;
                case 3:
                    System.out.print("Nhập mã NV cần sửa: ");
                    String idEdit = sc.nextLine();
                    for (int i = 0; i < empCount; i++) {
                        if (arrEmp[i].getEmployeeId().equals(idEdit)) {
                            arrEmp[i].inputUpdate(sc); break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã NV cần xóa: ");
                    String idDel = sc.nextLine();
                    for (int i = 0; i < empCount; i++) {
                        if (arrEmp[i].getEmployeeId().equals(idDel)) {
                            for (int j = i; j < empCount - 1; j++) arrEmp[j] = arrEmp[j + 1];
                            empCount--; break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên tìm kiếm: ");
                    String nameSearch = sc.nextLine().toLowerCase();
                    for (int i = 0; i < empCount; i++) {
                        if (arrEmp[i].getEmployeeName().toLowerCase().contains(nameSearch)) arrEmp[i].displayData();
                    }
                    break;
                case 6:
                    for (int i = 0; i < empCount - 1; i++) {
                        for (int j = i + 1; j < empCount; j++) {
                            if (arrEmp[i].getSalary() < arrEmp[j].getSalary()) {
                                Employee temp = arrEmp[i]; arrEmp[i] = arrEmp[j]; arrEmp[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong.");
                    break;
            }
        }
    }

    private static void menuProject() {
        while (true) {
            System.out.println("\n================ QUẢN LÝ DỰ ÁN ================");
            System.out.println("1. Thêm dự án");
            System.out.println("2. Hiển thị danh sách dự án");
            System.out.println("3. Cập nhật thông tin dự án");
            System.out.println("4. Xóa dự án (chưa có NV)");
            System.out.println("5. Thêm nhân viên vào dự án");
            System.out.println("6. Tìm dự án theo tên");
            System.out.println("7. Thống kê NV theo vai trò trong từng dự án");
            System.out.println("8. Dự án đang chạy và gần kết thúc nhất");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 9) break;
            switch (choice) {
                case 1:
                    Project p = new Project();
                    p.inputData(sc, arrPro, proCount);
                    arrPro[proCount++] = p;
                    break;
                case 2:
                    for (int i = 0; i < proCount; i++) arrPro[i].displayData();
                    break;
                case 3:
                    System.out.print("Mã dự án cần sửa: ");
                    String idP = sc.nextLine();
                    for (int i = 0; i < proCount; i++) {
                        if (arrPro[i].getProjectId().equals(idP)) {
                            arrPro[i].inputUpdate(sc, arrPro, proCount); break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Mã dự án cần xóa: ");
                    String idDel = sc.nextLine();
                    for (int i = 0; i < proCount; i++) {
                        if (arrPro[i].getProjectId().equals(idDel)) {
                            if (arrPro[i].getEmployees().length == 0) {
                                for (int j = i; j < proCount - 1; j++) arrPro[j] = arrPro[j + 1];
                                proCount--; System.out.println("Xóa thành công.");
                            } else System.err.println("Dự án đã có nhân viên, không thể xóa!");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Mã dự án: "); String idPr = sc.nextLine();
                    System.out.print("Mã nhân viên: "); String idEm = sc.nextLine();
                    Project targetP = null; Employee targetE = null;
                    for (int i = 0; i < proCount; i++) if (arrPro[i].getProjectId().equals(idPr)) targetP = arrPro[i];
                    for (int i = 0; i < empCount; i++) if (arrEmp[i].getEmployeeId().equals(idEm)) targetE = arrEmp[i];
                    if (targetP != null && targetE != null) targetP.addEmployeeToProject(targetE);
                    else System.err.println("Không tìm thấy dự án hoặc nhân viên!");
                    break;
                case 6:
                    System.out.print("Tên dự án: "); String nameP = sc.nextLine().toLowerCase();
                    for (int i = 0; i < proCount; i++) if (arrPro[i].getProjectName().toLowerCase().contains(nameP)) arrPro[i].displayData();
                    break;
                case 7:
                    for (int i = 0; i < proCount; i++) {
                        System.out.println("Dự án: " + arrPro[i].getProjectName());
                        int dev=0, tester=0, pm=0, ba=0;
                        for (Employee e : arrPro[i].getEmployees()) {
                            if (e.getRole() == Role.DEV) dev++;
                            else if (e.getRole() == Role.TESTER) tester++;
                            else if (e.getRole() == Role.PM) pm++;
                            else if (e.getRole() == Role.BA) ba++;
                        }
                        System.out.printf("   DEV: %d | TESTER: %d | PM: %d | BA: %d\n", dev, tester, pm, ba);
                    }
                    break;
                case 8:
                    Project nearFinish = null;
                    LocalDate now = LocalDate.now();
                    for (int i = 0; i < proCount; i++) {
                        if (arrPro[i].getStatus() == ProjectStatus.RUNNING) {
                            if (nearFinish == null || arrPro[i].getEndDate().isBefore(nearFinish.getEndDate())) {
                                nearFinish = arrPro[i];
                            }
                        }
                    }
                    if (nearFinish != null) {
                        System.out.println("Dự án đang chạy gần kết thúc nhất:");
                        nearFinish.displayData();
                    } else System.out.println("Không có dự án nào đang chạy.");
                    break;
            }
        }
    }

    private static void showEmployeeList() {
        if (empCount == 0) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        String line = "+----------+---------------------------+------------+-----------------+";
        System.out.println(line);

        System.out.printf("| %-8s | %-25s | %-10s | %-15s |\n",
                "Mã NV", "Tên nhân viên", "Chức vụ", "Lương");

        System.out.println(line);

        for (int i = 0; i < empCount; i++) {
            arrEmp[i].displayData();
        }
        System.out.println(line);
    }
}