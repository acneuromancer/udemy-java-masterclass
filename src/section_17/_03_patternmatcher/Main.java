package section_17._03_patternmatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");

        // String h2Pattern = ".*<h2>.*";
        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        // Before using again, the internal state of the matcher needs resetting;
        matcher.reset();
        // Look for occurencies of a pattern in a string
        int count = 0;
        while(matcher.find()) {
            ++count;
            System.out.println("Occurance " + count + ": " + matcher.start() + " to " + matcher.end());
        }

        // String h2GroupPattern = "(<h2>)";
        // String h2GroupPattern = "(<h2>.*</h2>)"; // * is the greedy quantifier

        // ? returns the * quantifier into a lazy quantifier.
        // If we are not interested in empty h2 tags, let us use .+? (+: at least one character)
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find()) {
            System.out.println("Occurence: " + groupMatcher.group(1)); // group(0) is the entire character sequence
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)"; // group(1), group(2), group(3)
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurence: " + h2TextMatcher.group(2));
        }
    }

}
