package section5_controlflow;

public class SharedDigit {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23)); // should return true
        System.out.println(hasSharedDigit(9, 99)); // should return false
        System.out.println(hasSharedDigit(15, 55)); // should return true
    }

    public static boolean hasSharedDigit(int firstNum, int secondNum) {
        if (firstNum < 10 || firstNum > 99 || secondNum < 10 || secondNum > 99) {
            return false;
        }

        int firstNumDigit1 = firstNum % 10;
        int firstNumDigit2 = firstNum / 10;
        int secondNumDigit1 = secondNum % 10;
        int secondNumDigit2 = secondNum / 10;

        return firstNumDigit1 == secondNumDigit1 ||
                firstNumDigit1 == secondNumDigit2 ||
                firstNumDigit2 == secondNumDigit1 ||
                firstNumDigit2 == secondNumDigit2;
    }

}
