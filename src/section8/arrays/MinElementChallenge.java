package section8.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinElementChallenge {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How many numbers should I read?");
        int count = scanner.nextInt();
        scanner.nextLine();

        int[] inputtedNumbers = readIntegers(count);
        System.out.println(Arrays.toString(inputtedNumbers));
        System.out.println("The minimum value in the array is " + findMin(inputtedNumbers));

        scanner.close();
    }

    public static int[] readIntegers(int count) {
        int[] array = new int[count];

        for (int i=0; i<count; i++) {
            System.out.println("Number #" + (i+1) + ":");
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }

        return array;
    }

    public static int findMin(int[] array) {
        int min = array[0];

        for (int i=1; i<array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

}
