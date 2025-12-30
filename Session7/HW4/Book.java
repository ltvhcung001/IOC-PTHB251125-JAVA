public class Book {
    public String title;
    public String author;
    public double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo(){
        System.out.println("Ten quyen sach: " + title);
        System.out.println("Ten tac gia: " + author);
        System.out.println("Gia tien: " + price);
    }
}
