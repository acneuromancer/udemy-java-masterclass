package section_08.arraylist;

import java.util.Arrays;

public class ResizeArray {

    public static void main(String[] args) {
        int[] myArray = new int[] {1, 2, 3, 4};
        System.out.println("Original array = " + Arrays.toString(myArray) + ", length: " + myArray.length);
        myArray = resizeArray(myArray, 10);
        System.out.println("Resized array = " + Arrays.toString(myArray) + ", length: " + myArray.length);
    }

    public static int[] resizeArray(int[] baseArray, int newLength) {
        if (newLength < baseArray.length) {
           return baseArray;
        }

        int[] newArray = new int[newLength];

        for (int i=0; i<baseArray.length; i++) {
            newArray[i] = baseArray[i];
        }

        return newArray;
    }

}
