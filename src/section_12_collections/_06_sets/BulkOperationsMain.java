package section_12_collections._06_sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BulkOperationsMain {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");

        // Union

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements.\n");

        // Intersection

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("intersection contains " + intersection.size() + " elements.");

        for (int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }
        System.out.println("\n");

        // Arrays.asList() method

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

        // Assymetric difference

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("\nnature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("\ndivine - nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        // Symmetric difference

        System.out.println("\nSymmetric difference (union - intersection):");

        Set<String> unionForSymmetricDiff = new HashSet<>(nature);
        unionForSymmetricDiff.addAll(divine);

        Set<String> intersectionForSymmetricDiff = new HashSet<>(nature);
        intersectionForSymmetricDiff.retainAll(divine);

        unionForSymmetricDiff.removeAll(intersectionForSymmetricDiff);
        printSet(unionForSymmetricDiff);
        System.out.println();

        // Test whether they are subsets

        if (nature.containsAll(divine)) {
            System.out.println("\nDivine is a subset of nature");
        } else {
            System.out.println("Divine is not a subset of nature");
        }

        if (nature.containsAll(intersectionForSymmetricDiff)) {
            System.out.println("intersection is a subset of nature");
        } else {
            System.out.println("intersection is not a subset of nature");
        }

        if (divine.containsAll(intersectionForSymmetricDiff)) {
            System.out.println("intersection is a subset of divine");
        } else {
            System.out.println("intersection is not a subset of divine");
        }
    }

    public static <T> void printSet(Set<T> set) {
        System.out.print("\t");
        for (T s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}
