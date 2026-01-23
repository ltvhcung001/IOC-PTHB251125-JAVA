
public class FullTimeEmployee extends Employee implements BonusEligible{
    double basicSalary;
    
    

    public FullTimeEmployee(int id, String name, double basicSalary) {
        super(id, name);
        this.basicSalary = basicSalary;
    }
    
    @Override
    double calculateSalary() {
        return basicSalary;
    }

    @Override
    public double calculateBonus() {
        return basicSalary * 0.05;
    }

}
