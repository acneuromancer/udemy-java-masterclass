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

        //a, e, or i (simple class)
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));

        // Do a replacement if a letter a, e, or i is followed by an F or a j.
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
        System.out.println("Harry".replaceAll("[Hh]arry", "Harry"));

        // Any characters except e,j (negotiation)
        System.out.println(alphanumeric.replaceAll("[^ej]", "X"));

        System.out.println(alphanumeric.replaceAll("[abcdef345678]", "X"));
        // a through f, or A through Z, or 3 through 8, inclusive (range)
        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        // not case sensitively
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X"));

        // replace every digit
        System.out.println(alphanumeric.replaceAll("[0-9]", "X"));
        // every digit (\d class)
        System.out.println(alphanumeric.replaceAll("\\d", "X"));
        // every non-digit (\D class)
        System.out.println(alphanumeric.replaceAll("\\D", "X"));

        String hasWhitespaces = "I have blanks and \ta tab, and also a newline.\n";
        System.out.println(hasWhitespaces);
        // every whitespace character (\s)
        System.out.println(hasWhitespaces.replaceAll("\\s", ""));
        // every non-whitespace character (\S)
        System.out.println(hasWhitespaces.replaceAll("\\S", "non-whitespace"));

        // every word
        System.out.println(hasWhitespaces.replaceAll("\\w", "X"));
        // every non-word
        System.out.println(hasWhitespaces.replaceAll("\\W", "X"));
        // whole words boundaries
        System.out.println(hasWhitespaces.replaceAll("\\b", "X"));
    }

}