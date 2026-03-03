public class Enrollment {
    private int studentId;
    private int courseId;
    private Double grade;

    public Enrollment(int studentId, int courseId, Double grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }
    
    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public Double getGrade() { return grade; }
}