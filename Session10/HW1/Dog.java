public class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}
