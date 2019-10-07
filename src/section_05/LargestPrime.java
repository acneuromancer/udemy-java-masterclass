package section_05;

public class LargestPrime {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(21)); // should return 7
        System.out.println(getLargestPrime(217)); // should return 31
        System.out.println(getLargestPrime(0)); // should return -1
        System.out.println(getLargestPrime(45)); // should return 5
        System.out.println(getLargestPrime(-1)); // should return -1
    }

    public static int getLargestPrime(int number) {
        if (number <=  0 || number == 1) {
            return -1;
        }

        int largestPrime = 2;

        for (int i = 2; i < number; i++) {
            while(number % i == 0) {
                if (i > largestPrime) {
                    largestPrime = i;
                }

                number /= i;
            }
        }

        if (number > 2) {
            if (number > largestPrime) {
                largestPrime = number;
            }
        }

        return largestPrime;
    }

}
