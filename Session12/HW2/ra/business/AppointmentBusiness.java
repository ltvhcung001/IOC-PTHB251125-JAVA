package ra.business;

import ra.entity.Appointment;
import java.util.*;
import java.util.stream.Collectors;

public class AppointmentBusiness {
    public static List<Appointment> appointmentList = new ArrayList<>();

    public void addAppointment(Scanner scanner) {
        Appointment newApp = new Appointment();
        newApp.inputData(scanner, appointmentList);
        appointmentList.add(newApp);
        System.out.println("Thêm lịch hẹn thành công!");
    }

    public void displayAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("--- DANH SÁCH LỊCH HẸN (Sắp xếp theo ngày) ---");
        appointmentList.stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .forEach(System.out::println);
    }

    public void searchByName(Scanner scanner) {
        System.out.print("Nhập tên bệnh nhân cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        List<Appointment> result = appointmentList.stream()
                .filter(a -> a.getPatientName().toLowerCase().contains(name))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy bệnh nhân phù hợp.");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void updateAppointment(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn cần cập nhật: ");
        String id = scanner.nextLine();
        Optional<Appointment> opt = appointmentList.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst();

        // ifPresentOrElse có từ Java 9. Nếu dùng Java 8 thuần túy, ta dùng if(opt.isPresent())
        opt.ifPresentOrElse(
                app -> {
                    System.out.println("Nhập thông tin mới (để trống nếu không muốn thay đổi):");
                    // Logic cập nhật nhanh (có thể tái sử dụng logic validate của inputData)
                    System.out.print("Tên BN mới: ");
                    String name = scanner.nextLine();
                    if(!name.isEmpty()) app.setPatientName(name);

                    System.out.print("SĐT mới: ");
                    String phone = scanner.nextLine();
                    if(!phone.isEmpty()) app.setPhoneNumber(phone);

                    System.out.println("Cập nhật thành công!");
                },
                () -> System.err.println("Không tìm thấy mã lịch hẹn!")
        );
    }

    public void deleteAppointment(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn cần xóa: ");
        String id = scanner.nextLine();
        Optional<Appointment> opt = appointmentList.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst();

        if (opt.isPresent()) {
            System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                appointmentList.remove(opt.get());
                System.out.println("Đã xóa thành công.");
            }
        } else {
            System.err.println("Mã lịch hẹn không tồn tại.");
        }
    }

    public void statistics() {
        System.out.println("Tổng số lịch hẹn: " + appointmentList.size());
        Map<String, Long> stats = appointmentList.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctor, Collectors.counting()));

        System.out.println("Thống kê theo bác sĩ:");
        stats.forEach((doctor, count) -> System.out.println("Bác sĩ " + doctor + ": " + count + " lịch hẹn"));
    }
}