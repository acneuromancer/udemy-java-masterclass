package section_17._02_quantifiers;

public class Main {

    public static void main(String[] args) {
        String alphanumericString = "abcDeeeF12Ghhiiiijkl99z";

        // X{n} - X exactly  times
        System.out.println(alphanumericString.replaceAll("^abcDe{3}", "YYY"));

        // X+ - X one or more times
        System.out.println(alphanumericString.replaceAll("^abcDe+", "YYY"));

        // X* - X zero or more times
        System.out.println(alphanumericString.replaceAll("^abcDe*", "YYY"));
        System.out.println(alphanumericString.replaceAll("^abcDx*", "YYY"));

        // X{n,} - X at least n times
        System.out.println(alphanumericString.replaceAll("^abcDe{2,}", "YYY"));
        System.out.println(alphanumericString.replaceAll("^abcDe{5,}", "YYY"));

        // X{n, m} - X at least n but not more than m times
        System.out.println(alphanumericString.replaceAll("^abcDe{1,3}", "YYY"));

        System.out.println(alphanumericString.replaceAll("h+i*j", "Y"));
    }

}
