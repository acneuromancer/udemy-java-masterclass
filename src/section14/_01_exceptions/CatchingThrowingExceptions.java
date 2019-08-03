package section14._01_exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CatchingThrowingExceptions {

    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);
    }

    public static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("no suitable input");
        }
        System.out.println("x is " + x + ", y is " + y);

        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("attempt to divide by zero");
        }
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while(true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                // Go round again. rEad past the end of line in the input first.
                scanner.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }
    }

}
