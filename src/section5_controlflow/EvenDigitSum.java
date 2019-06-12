package section5_controlflow;

public class EvenDigitSum {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789)); // should return 20
        System.out.println(getEvenDigitSum(252)); // should return 4
        System.out.println(getEvenDigitSum(-22)); // should return -1

    }

    public static int getEvenDigitSum(int number) {
        if (number < 0)
            return -1;

        int sum = 0;

        while(number != 0) {
            int leastSignificantDigit = number % 10;

            if (leastSignificantDigit % 2 == 0) {
                sum += leastSignificantDigit;
            }

            number /= 10;
        }

        return sum;
    }

}
