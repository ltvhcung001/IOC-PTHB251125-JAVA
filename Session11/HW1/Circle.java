
public class Circle extends Shape implements Drawable{
    double radius;

    public Circle(double radius) {
        super("Hình tròn");
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Đã vẽ hình tròn.");
    }

    @Override
    double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    double getPerimeter() {
        return radius * 2 * Math.PI;
    }
    
}
