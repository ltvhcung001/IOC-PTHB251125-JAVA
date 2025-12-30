public class Course{
    public String code;
    public String title;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public void showCourse(){
        System.out.println("Course code: " + code);
        System.out.println("Course title: "+ title);
    }
}