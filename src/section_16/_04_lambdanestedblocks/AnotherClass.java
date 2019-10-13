package section_16._04_lambdanestedblocks;

public class AnotherClass {

    public String doSomething() {
        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());

        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperConcat(String s1, String s2) {
                System.out.println("The anonymous class's name is " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");
    }

    public String doSomethingLambda() {
        UpperConcat uc = (s1, s2) -> {
            // A lambda expression is not a class, an anonymous instance is not created.
            // A lambda is treated like a nest block of code.
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }

    public String doSomethingScopeAnonymousClass() {
        // Local variables used in an anonymous class have to be final.
        final int i = 0;

        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperConcat(String s1, String s2) {
                    System.out.println("i within anonymous class = " + i);
                    return s1.toUpperCase() + s2.toUpperCase();
                }
            };

            System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
            // i++;
            System.out.println("i = " + i);

            return Main.doStringStuff(uc, "String1", "String2");
        }
    }

    public String doSomethingScopeLambda() {
        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("i = " + i);
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }

}
