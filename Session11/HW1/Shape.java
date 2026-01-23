
public abstract class Shape {
    String name;

    public Shape(String name) {
        this.name = name;
    }
    
    abstract double getArea();
    abstract double getPerimeter();
    void displayInfo(){
        System.out.println("Tên hình: " + name);
    }
}
