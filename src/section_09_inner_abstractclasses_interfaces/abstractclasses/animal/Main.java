package section_09_inner_abstractclasses_interfaces.abstractclasses.animal;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("yorkie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Australian ringneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.breathe();
        penguin.eat();
        penguin.fly();
    }

}
