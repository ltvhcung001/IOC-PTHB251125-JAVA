
import java.util.ArrayList;

public class HW2 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", 9.99);
        books.add(book1);
        Book book2 = new Book("Pride and Prejudice", "Jane Austen", 7.99);
        books.add(book2);
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", 11.99);
        books.add(book3);

        System.out.println("---- List of Books ----");
        for (Book book : books) {
            book.printInfo();
        }
    }
}
