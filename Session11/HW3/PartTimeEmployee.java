
public class PartTimeEmployee extends Employee{
    double workingHours;
    double salaryByHour;

    

    

    public PartTimeEmployee(int id, String name, double workingHours, double salaryByHour) {
        super(id, name);
        this.workingHours = workingHours;
        this.salaryByHour = salaryByHour;
    }

    @Override
    double calculateSalary() {
        return workingHours * salaryByHour;        
    }

}
