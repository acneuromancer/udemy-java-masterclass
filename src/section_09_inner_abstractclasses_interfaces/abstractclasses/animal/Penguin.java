package section_09_inner_abstractclasses_interfaces.abstractclasses.animal;

public class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("I am not very good at that, can I go for a swim instead?");
    }

}
