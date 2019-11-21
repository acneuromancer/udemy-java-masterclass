package section_16_lambda._03_stringconcat;

public class Main {

    public static void main(String[] args) {
        String myString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "Hello", "World");

        System.out.println(myString);

        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase() + s2.toUpperCase();
        myString = doStringStuff(uc, "Hello", "World");
        System.out.println(myString);

        myString = doStringStuff((s1, s2) -> {
            // If the lambda body contains more statements, or we add the curly braces,
            // we have to return the result explicitly.
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        }, "Hello", "World");
        System.out.println(myString);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }

}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}
