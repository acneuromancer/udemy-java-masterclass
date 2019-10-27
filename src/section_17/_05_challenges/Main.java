package section_17._05_challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        /*
        Challenge #1: Write the string literal regular expression that will match the following String.
        Use the String.matches() method to verify your answer.
        */
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        /*
        Challenge #2: Write a regular expression that will match "I want a bike." and "I want a ball."
        Verify your answer using the matches() method.
        */
        String challenge2 = "I want a ball.";
        String regExp1 = "I want a \\w+.";
        System.out.println(challenge2.matches(regExp1));

        String regExp2 = "I want a (bike|ball).";
        System.out.println(challenge2.matches(regExp2));

        /*
        Challenge #3: In the prevoious challenge, use the Matcher.matches() method to check for matches, instead
        of String.matches(), for the regular expression that uses \w+.
        */
        Pattern pattern = Pattern.compile(regExp1);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());

        /*
        Challenge #4: Replace all occurences of blank with an underscore for the following string.
        Print out the resulting string.
        */
        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));

        /*
        Challenge #5: Write a regular expression that will match the following string in its entirety.
        Use the String.matches() method to verify your answer.
        */
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

        /*
        Challenge #6: Write a regular expression that will only match the challenge 5 string in its entirety.
        */
        System.out.println(challenge5.matches("a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.replaceAll("a{3}bc{8}d{3}ef{3}g$", "REPLACED"));

        /*
        Challenge #7: Write a regular expression that will match a string that starts with a series of letters. The letters
        must be followed by a period. After the period, there must be a series of digits. The string "kjisl.22" would match.
        The string "f5.12a" would not. Use the string to test your regular expression.
        */
        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$"));

        /*
        Challenge #8: Modify the regular expression in challenge 7 to use a group, so that we can print all the digits that occur
        in a string that contains multiple occurences of the pattern.
         */
        String challenge8 = "abcd.135uvqz.7tzik.999";
        pattern = Pattern.compile("[A-za-z]+\\.(\\d+)");
        matcher = pattern.matcher(challenge8);

        while(matcher.find()) {
            System.out.println("Occurence: " + matcher.group(1));
        }

        /*
        Challenge #9: Let's suppose we're reading strings that match the patterns we used in challenges 7 and 8 from a file.
        Tabs are used to separate the matches, with one exception. The last match is followed by a newline.
        */
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        pattern = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        matcher = pattern.matcher(challenge9);

        while(matcher.find()) {
            System.out.println("Occurence: " + matcher.group(1));
        }

         /*
        Challenge #10: Instead printing out the numbers themselves, print out their start and end indices.
        Use the same string we used for challenge 9. Make those indices inclusive.
        */
        pattern = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        matcher = pattern.matcher(challenge9);

        while(matcher.find()) {
            System.out.println("Occurence: start = " + matcher.start(1) + " end = " + (matcher.end(1)-1));
        }
    }

}
