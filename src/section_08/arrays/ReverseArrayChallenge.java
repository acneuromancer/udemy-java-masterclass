package section_08.arrays;

import java.util.Arrays;

public class ReverseArrayChallenge {

    public static void main(String[] args) {
        int[] myArray = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println("The array to reverse: " + Arrays.toString(myArray));
        reverse(myArray);
        System.out.println("The reversed array: " + Arrays.toString(myArray) + "\n");

        myArray = new int[] {1, 2, 3};
        System.out.println("The array to reverse: " + Arrays.toString(myArray));
        reverse(myArray);
        System.out.println("The reversed array: " + Arrays.toString(myArray));
    }

    public static void reverse(int[] array) {
        int lastPosition = array.length-1;

        for (int i=0; i<array.length/2; i++) {
            int temp = array[i];
            array[i] = array[lastPosition-i];
            array[lastPosition-i] = temp;
        }
    }

}
