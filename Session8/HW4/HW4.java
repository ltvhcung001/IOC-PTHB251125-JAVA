

public class HW4 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(5, 2);
        Rectangle r3 = new Rectangle(4.5, 3.5);
        
        System.out.println("Rectangle 1: width = " + r1.getWidth() + ", height = " + r1.getHeight() + 
                           ", area = " + r1.getArea() + ", perimeter = " + r1.getPerimeter());
        System.out.println("Rectangle 2: width = " + r2.getWidth() + ", height = " + r2.getHeight() + 
                           ", area = " + r2.getArea() + ", perimeter = " + r2.getPerimeter());
        System.out.println("Rectangle 3: width = " + r3.getWidth() + ", height = " + r3.getHeight() + 
                           ", area = " + r3.getArea() + ", perimeter = " + r3.getPerimeter());
        double max = Math.max(r1.getArea(), Math.max(r2.getArea(), r3.getArea()));
        System.out.print("Largest area = " + max + " ");
        int cnt = 0;
        if (max == r1.getArea()) cnt++;
        if (max == r2.getArea()) cnt++;
        if (max == r3.getArea()) cnt++;
        if (cnt > 1){
            System.out.print("There are multiple rectangles with the largest area: ");
        }
        if (max == r1.getArea())
            System.out.println("(Rectangle 1: width = " + r1.getWidth() + ", height = " + r1.getHeight() + ")");
        else if (max == r2.getArea())
            System.out.println("(Rectangle 2: width = " + r2.getWidth() + ", height = " + r2.getHeight() + ")");
        else
            System.out.println("(Rectangle 3: width = " + r3.getWidth() + ", height = " + r3.getHeight() + ")");
    }
}
