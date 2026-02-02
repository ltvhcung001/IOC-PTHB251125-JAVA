package ra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {}

    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    // Getters and Setters
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }

    public void inputData(Scanner scanner, List<Appointment> list) {
        // 1. Mã lịch hẹn: 6 ký tự, không trùng
        while (true) {
            System.out.print("Nhập mã lịch hẹn (6 ký tự): ");
            this.appointmentId = scanner.nextLine();
            if (this.appointmentId.length() == 6) {
                boolean isExist = list.stream().anyMatch(a -> a.getAppointmentId().equals(this.appointmentId));
                if (!isExist) break;
                else System.err.println("Mã lịch hẹn đã tồn tại!");
            } else System.err.println("Mã lịch hẹn phải đúng 6 ký tự!");
        }

        // 2. Tên bệnh nhân: 10-50 ký tự
        while (true) {
            System.out.print("Nhập tên bệnh nhân (10-50 ký tự): ");
            this.patientName = scanner.nextLine();
            if (this.patientName.length() >= 10 && this.patientName.length() <= 50) break;
            else System.err.println("Tên phải từ 10-50 ký tự!");
        }

        // 3. Số điện thoại: Định dạng VN (0... 10 số)
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            this.phoneNumber = scanner.nextLine();
            if (this.phoneNumber.matches("^0[0-9]{9}$")) break;
            else System.err.println("Số điện thoại không đúng định dạng VN (10 số, bắt đầu bằng 0)!");
        }

        // 4. Ngày hẹn: dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhập ngày hẹn (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            try {
                this.appointmentDate = LocalDate.parse(dateStr, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Ngày hẹn không đúng định dạng dd/MM/yyyy!");
            }
        }

        // 5. Bác sĩ: tối đa 200 ký tự
        while (true) {
            System.out.print("Nhập tên bác sĩ phụ trách: ");
            this.doctor = scanner.nextLine();
            if (this.doctor.length() <= 200 && !this.doctor.isEmpty()) break;
            else System.err.println("Tên bác sĩ không được để trống và tối đa 200 ký tự!");
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %s | BN: %-15s | SĐT: %s | Ngày: %s | BS: %s",
                appointmentId, patientName, phoneNumber,
                appointmentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), doctor);
    }
}