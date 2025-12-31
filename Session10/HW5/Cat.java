
public class Cat extends Mammal {

    public Cat(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound(){
        System.out.println("Meow Meow");
    }

    public void climbTree(){
        System.out.println("Cat is climbing the tree");
    }
    
}
