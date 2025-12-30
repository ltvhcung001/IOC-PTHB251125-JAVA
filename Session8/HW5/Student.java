
import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private double gpa;
    
    final double SCORE_FACTOR = 0.25;
    private static int countStudent = 0;

    public Student() {
        this.countStudent++;
    }

    public Student(int id, String name, double gpa) {
        this();
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void input(Scanner sc){
        String temp;
        System.out.print("Nhập ID sinh viên: ");
        temp = sc.nextLine();
        try {
            this.id = Integer.parseInt(temp);
        } catch (Exception e) {
        }
        System.out.print("Nhập tên sinh viên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập GPA: ");
        temp = sc.nextLine();
        try {
            this.gpa = Double.parseDouble(temp);
        } catch (Exception e) {
        }
    }

    public void print(){
        System.out.println("ID: " + id + ", Name: " + name + ", GPA: " + gpa);
    }
    
    public double getGpa() {
        return gpa;
    }

    public static int getTotalStudent(){
        return countStudent;
    }
}
