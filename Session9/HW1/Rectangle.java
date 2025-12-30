public class Rectangle {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return 2 * (height + width);
    }

    public void printInfo() {
        System.out.println("Height: " + height + ", Width: " + width + 
                           ", Area: " + getArea() + 
                           ", Perimeter: " + getPerimeter());
    }
}
