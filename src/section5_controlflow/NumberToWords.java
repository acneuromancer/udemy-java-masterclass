package section5_controlflow;

public class NumberToWords {

    public static void main(String[] args) {
       numberToWords(10);
    }

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        if (number == 0) {
            System.out.println("Zero");
            return;
        }

        int reversedNumber = reverse(number);

        int diff = getDigitCount(number) - getDigitCount(reversedNumber);

        while(reversedNumber > 0) {
            int leastSignificantDigit = reversedNumber % 10;

            switch (leastSignificantDigit) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }

            reversedNumber /= 10;
        }

        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                System.out.println("Zero");
            }
        }
    }

    public static int reverse(int number) {
        int reversedNumber = 0;

        while(number != 0) {
            int leastSignificantDigit = number % 10;
            reversedNumber *= 10;
            reversedNumber += leastSignificantDigit;
            number /= 10;
        }

        return reversedNumber;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }

        if (number == 0) {
            return 1;
        }

        int digitCount = 0;

        while(number > 0) {
            number /= 10;
            digitCount++;
        }

        return digitCount;
    }

}
