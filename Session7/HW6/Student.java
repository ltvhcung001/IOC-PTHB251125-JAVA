
public class Student {
    public int id;
    public String name;
    public Course course;

    public Student(int id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }
    
    public void displayInfo(){
        System.out.println("ID: " + id);
        System.out.println("Name: "+ name);
        course.showCourse();
    }
}
