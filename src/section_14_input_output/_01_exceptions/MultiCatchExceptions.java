package section_14_input_output._01_exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MultiCatchExceptions {

    public static void main(String[] args) {
//        divide2();

        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }
    }

    public static int divide() {
        int x, y;
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    public static int divide2() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("no suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("attempt to divide by zero");
        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while(true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                // Go round again. Read past the end of line in the input first.
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }
    }

}
