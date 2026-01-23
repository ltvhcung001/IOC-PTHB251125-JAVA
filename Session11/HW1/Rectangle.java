
public class Rectangle extends Shape implements Drawable{
    double width;
    double height;

    public Rectangle(double width, double height) {
        super("Hình chữ nhật");
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }
    
    @Override
    double getPerimeter() {
        return (width + width) * 2;
    }

    @Override
    public void draw() {
        System.out.println("Đã vẽ hình chữ nhật");
    }
}
