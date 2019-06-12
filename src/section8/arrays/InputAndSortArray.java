package section8.arrays;

import java.util.Scanner;

public class InputAndSortArray {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);
    }

    private static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.println("#" + i + ": " + array[i]);
        }
    }

    private static int[] getIntegers(int capacity) {
        int[] array = new int[capacity];

        System.out.println("Enter " + capacity + " integer values:");

        for (int i=0; i<array.length; i++) {
            while(true) {
                boolean hasNextInt = scanner.hasNextInt();
                if (hasNextInt) {
                    array[i] = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Invalid Value");
                    scanner.nextLine();
                }
            }
        }

        return array;
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length];

        for (int i=0; i<array.length; i++) {
            sortedArray[i] = array[i];
        }

        boolean flag = true;
        int temp;

        while(flag) {
            flag = false;
            for (int i=0; i<sortedArray.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }

        return sortedArray;
    }

}
