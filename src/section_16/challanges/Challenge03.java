package section_16.challanges;

import java.util.function.Function;

public class Challenge03 {

    public static void main(String[] args) {
        // System.out.println("Watermelon: " + everySecondChar("watermelon"));

        Function<String, String> charFilter = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); ++i) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(charFilter.apply("1234567890"));
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();

        for (int i = 0; i < source.length(); ++i) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }

}
