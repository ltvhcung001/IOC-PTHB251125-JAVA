import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Manage<Student> {
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student item) {
        studentList.add(item);
    }

    @Override
    public void update(int index, Student item) {
        if (index >= 0 && index < studentList.size()) {
            studentList.set(index, item);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < studentList.size()) {
            studentList.remove(index);
        }
    }

    @Override
    public void display() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println((i+1) + ". " + studentList.get(i));
            }
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}