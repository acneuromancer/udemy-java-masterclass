package section_16._04_lambdanestedblocks;

public class Main {

    public static void main(String[] args) {
        AnotherClass anotherClass = new AnotherClass();
        String result = anotherClass.doSomethingScopeLambda();
        System.out.println(result);

        anotherClass.printValue();
    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperConcat(s1, s2);
    }

}

interface UpperConcat {
    public String upperConcat(String s1, String s2);
}