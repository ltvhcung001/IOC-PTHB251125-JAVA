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
        System.out.println("Tên quyển sách: " + title);
        System.out.println("Tên tác giả: " + author);
        System.out.println("Giá tiền: " + price);
    }
}
