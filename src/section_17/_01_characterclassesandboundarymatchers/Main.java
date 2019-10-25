package section_17._01_characterclassesandboundarymatchers;

public class Main {

    public static void main(String[] args) {
        // The simplest form of a regular expression is a string literal.
        String string = "I am a string. Yes, I am.";
        System.out.println(string);

        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString = "abcDeeeF12Ghhiiiijkl99zabcDeee";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        // In case of matches() method the string as a whole has to match the regular expression
        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhiiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));

        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));

        // Do a replacement if a letter a, e, or i is followed by an F or a j.
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

    }
}