package section5_controlflow;

public class LastDigitChecker {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(123, 13, 11));
        System.out.println(hasSameLastDigit(-1, 0, 0));
        System.out.println(hasSameLastDigit(99, 15, 109));
    }

    public static boolean hasSameLastDigit(int firstNumber, int secondNumber, int thirdNumber) {
        if (!isValid(firstNumber) || !isValid(secondNumber) || !isValid(thirdNumber)) {
            return false;
        }

        int firstNumberLastDigit = firstNumber % 10;
        int secondNumberLastDigit = secondNumber % 10;
        int thirdNumberLastDigit = thirdNumber % 10;

        return firstNumberLastDigit == secondNumberLastDigit ||
                firstNumberLastDigit == thirdNumberLastDigit ||
                secondNumberLastDigit == thirdNumberLastDigit;

    }

    public static boolean isValid(int number) {
        return number >= 10 && number <= 1000;
    }

}
