package section8.arrays;

import java.util.Scanner;

public class InputArray {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        printArray(myIntegers);
        System.out.println("The average is " + getAverage(myIntegers));
        scanner.close();
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for (int i=0; i<values.length; i++) {
            while(true) {
                boolean hasNextInt = scanner.hasNextInt();
                if (!hasNextInt) {
                    System.out.println("Invalid Value");
                    scanner.nextLine();
                    continue;
                } else {
                    values[i] = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }
            }
        }

        return values;
    }

    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.println("Element #" + i + ": " + array[i]);
        }
    }

    public static double getAverage(int[] array) {
        int sum = 0;
        for (int i=0; i<array.length; i++) {
            sum += array[i];
        }
        return (double) sum / (double) array.length;
    }

}
