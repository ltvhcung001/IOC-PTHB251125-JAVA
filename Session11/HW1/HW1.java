public class HW1 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Rectangle(5.0, 3.0);
        shapes[1] = new Circle(4.0);
        System.out.println("Duyệt mảng Shape và in thông tin: ");
        for (int i = 0; i < shapes.length; i++){
            shapes[i].displayInfo();
            System.out.println("Diện tích: " + shapes[i].getArea());
            System.out.println("Chu vi: " + shapes[i].getPerimeter());
            if (shapes[i] instanceof Drawable)
                ((Drawable) shapes[i]).draw();
        }
    }
}
