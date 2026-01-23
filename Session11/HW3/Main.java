
public class Main {
    public static void main(String[] args) {
        System.out.println("Thưởng là 5% của lương");
        Employee[] employees = new Employee[2];
        employees[0] = new FullTimeEmployee(1, "Full time", 5_000_000);
        employees[1] = new PartTimeEmployee(2, "Part time", 30, 50_000);
        for (Employee employee : employees){
            employee.showInfo();
            System.out.println("Lương: " + employee.calculateSalary());
            if (employee instanceof BonusEligible){
                System.out.println("Phụ cấp: " + ((BonusEligible) employee).calculateBonus());
            }
        }
    }
}
