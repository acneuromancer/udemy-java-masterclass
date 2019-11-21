package section_05_controlflowstatements;

import java.util.Scanner;

public class MinAndMax {

    public static void main(String[] args) {
        getMinAndMax2();
    }

    public static void getMinAndMax() {
        System.out.println("Enter numbers (a char to exit):");

        Scanner scanner = new Scanner(System.in);

        int min = 0;
        int max = 0;
        boolean first = true;

        while(scanner.hasNextInt()) {
            int num = scanner.nextInt();
            scanner.nextLine();

            if (first) {
                min = max = num;
                first = false;
            }

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        System.out.println("Min: " + min + ", max: " + max);

        scanner.close();
    }

    public static void getMinAndMax2() {
        System.out.println("Enter numbers (a char to exit):");

        Scanner scanner = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        boolean isNextInt = scanner.hasNextInt();

        while(isNextInt) {
            int num = scanner.nextInt();
            scanner.nextLine();

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }

            isNextInt = scanner.hasNextInt();
        }

        System.out.println("Min: " + min + ", max: " + max);

        scanner.close();
    }

}
