package section11._final;

public class Main {

    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        // one.instanceNumber = 4; cannot assign a value to a final variable

        int pw = 674312;
        Password password = new Password(pw);
        password.storePassword();
        password.letMeIn(1);
        password.letMeIn(383835);
        password.letMeIn(3892);
        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(674312);

        ExtendedPassword extendedPassword = new ExtendedPassword(pw);
        extendedPassword.storePassword();
        extendedPassword.letMeIn(1);
        extendedPassword.letMeIn(383835);
        extendedPassword.letMeIn(3892);
        extendedPassword.letMeIn(0);
        extendedPassword.letMeIn(-1);
        extendedPassword.letMeIn(674312);
    }

}
