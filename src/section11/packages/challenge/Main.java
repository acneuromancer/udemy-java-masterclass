package section11.packages.challenge;

public class Main {

    public static void main(String[] args) {
        for (int i=0; i<=10; i++) {
            System.out.print(Series.nSum(i) + " ");
        }

        System.out.println("\n==============================");

        for (int i=0; i<=10; i++) {
            System.out.print(Series.factorial(i) + " ");
        }

        System.out.println("\n==============================");

        for (int i=0; i<=10; i++) {
            System.out.print(Series.fibonacci(i) + " ");
        }
    }

}
