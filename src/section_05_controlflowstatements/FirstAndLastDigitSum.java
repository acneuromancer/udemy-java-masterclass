package section_05_controlflowstatements;

public class FirstAndLastDigitSum {

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(252)); // should return 4
        System.out.println(sumFirstAndLastDigit(257)); // should return 9
        System.out.println(sumFirstAndLastDigit(0)); // should return 0
        System.out.println(sumFirstAndLastDigit(5)); // should return 10
        System.out.println(sumFirstAndLastDigit(-10)); // should return -1
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int firstDigit = number % 10;
        int lastDigit = firstDigit;
        number /= 10;

        while(number != 0) {
            int leastSignificantDigit = number % 10;
            number /= 10;
            if (number == 0) {
                lastDigit = leastSignificantDigit;
            }
        }

        return firstDigit + lastDigit;
    }

}
