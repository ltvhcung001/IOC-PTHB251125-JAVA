import ra.business.AppointmentBusiness;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentBusiness business = new AppointmentBusiness();

        while (true) {
            System.out.println("\n******************** QUẢN LÝ LỊCH HẸN ********************");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách lịch hẹn");
            System.out.println("3. Tìm kiếm lịch hẹn theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn theo mã lịch hẹn");
            System.out.println("5. Xóa lịch hẹn theo mã lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.println("**********************************************************");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng chọn số từ 1-7!");
                continue;
            }

            switch (choice) {
                case 1: business.addAppointment(scanner); break;
                case 2: business.displayAppointments(); break;
                case 3: business.searchByName(scanner); break;
                case 4: business.updateAppointment(scanner); break;
                case 5: business.deleteAppointment(scanner); break;
                case 6: business.statistics(); break;
                case 7:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}