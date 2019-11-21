package section_16_lambda.challanges;

import java.util.function.Function;

public class Challenge04 {

    public static void main(String[] args) {
        Function<String, String> charFilter = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); ++i) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondCharacter(charFilter, "123456789"));
    }

    public static String everySecondCharacter(Function<String, String> charFilter, String source) {
        return charFilter.apply(source);
    }

}
