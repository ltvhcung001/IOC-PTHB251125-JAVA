
public class Mammal extends Animal {
    boolean hasFur;

    public Mammal(String name, int age, boolean hasFur) {
        super(name, age);
        this.hasFur = hasFur;
    }
    @Override
    public void makeSound(){
        System.out.println("Mammal sound");
    }
    @Override
    public void eat(){
        System.out.println("Mammal is eating");
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("Has Fur: " + hasFur);
    }

    
}
