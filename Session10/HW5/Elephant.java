
public class Elephant extends Mammal {

    public Elephant(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound(){
        System.out.println("Trumpet Trumpet");
    }

    public void sprayWater(){
        System.out.println("Elephant is spraying water");
    }
    
}
