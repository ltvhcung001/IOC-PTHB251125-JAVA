
public class Animal {
    private String name;
    private int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void showInfo(){
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public void makeSound(){
        System.out.println("Animal makes a sound");
    }

    public void eat(){
        System.out.println("Animal is eating");
    }

    public void eat(String food){
        System.out.println("Animal is eating " + food);
    }
}
