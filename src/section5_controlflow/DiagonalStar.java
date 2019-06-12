package section5_controlflow;

public class DiagonalStar {

    public static void main(String[] args) {
        printSquareStar(5);
    }

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }

        for (int row = 1; row <= number; row++) {
            for (int col = 1; col <= number; col++) {
                if (row == 1 || row == number) {
                    System.out.print("*");
                } else if (col == 1 || col == number) {
                    System.out.print("*");
                } else if (row == col)  {
                    System.out.print("*");
                } else if (col == number - row +1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
     }

}
