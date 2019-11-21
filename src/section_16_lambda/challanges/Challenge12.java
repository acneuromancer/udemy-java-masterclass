package section_16_lambda.challanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge12 {

    public static void main(String[] args) {
        List<String> topNames2015 = Arrays.asList(
                "Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();

        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);


        long namesBeginWithA = topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Number of names beginning with A is " + namesBeginWithA);
    }

}
