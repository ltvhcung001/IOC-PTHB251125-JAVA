public class Student {
    private int id;
    private String name;
    private int age;
    private double gpa;
    static int count = 1;
    final double MIN_GPA = 0.0;
    final double MAX_GPA = 4.0;

    public Student() {
        this.id = count++;
    }

    public Student(String name, int age, double gpa) {
        this();
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    
    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
    }  
}
