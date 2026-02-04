import java.util.ArrayList;
import java.util.List;

public class InvoiceManager implements Manage<Invoice> {
    private List<Invoice> list = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        list.add(item);
    }

    @Override
    public void update(int index, Invoice item) {
        list.set(index, item);
    }

    @Override
    public void delete(int index) {
        list.remove(index);
    }

    @Override
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống.");
        } else {
            for (Invoice inv : list) {
                System.out.println(inv);
            }
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) return i;
        }
        return -1;
    }
}