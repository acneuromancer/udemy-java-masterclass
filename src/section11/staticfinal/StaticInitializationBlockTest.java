package section11.staticfinal;

public class StaticInitializationBlockTest {

    public static final String owner;

    static {
        owner = "Tim";
        System.out.println("StaticInitializationBlockTest static initialization block called.");
    }

    public StaticInitializationBlockTest() {
        System.out.println("StaticInitializationBlockTest constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }

    public static void main(String[] args) {
        System.out.println("ReadingBinaryFiles method called.");
        StaticInitializationBlockTest test = new StaticInitializationBlockTest();
        test.someMethod();
        System.out.println("Owner is " + StaticInitializationBlockTest.owner);
    }

}
