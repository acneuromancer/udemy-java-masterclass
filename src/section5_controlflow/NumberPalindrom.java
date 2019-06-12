package section5_controlflow;

public class NumberPalindrom {

    public static boolean isPalindrome(int number) {
        int reversedNumber = 0;
        int originalNumber = number;

        while(number != 0) {
            int leastSignificantDigit = number % 10;
            reversedNumber *= 10;
            reversedNumber += leastSignificantDigit;
            number /= 10;
        }

        return originalNumber == reversedNumber;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }
}
