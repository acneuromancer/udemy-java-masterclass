package section_04;

public class TeenNumberChecker {

    public static boolean hasTeen(int n1, int n2, int n3) {
        return (n1 >= 13 && n1 <= 19)  || (n2 >= 13 && n2 <= 19) || (n3 >= 13 && n3 <= 19);
    }

    public static boolean isTeen(int n) {
        return n >= 13 && n <= 19;
    }

}
