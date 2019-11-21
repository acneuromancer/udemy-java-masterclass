package section_08_arrays_lists_autounboxing.arrays;

import java.util.Arrays;

public class ReferenceTypeValueType {

    public static void main(String[] args) {
        int myInt = 10;
        int anotherInt = myInt;
        anotherInt++;
        System.out.println("myInt = " + myInt);
        System.out.println("anotherInt = " + anotherInt);

        int[] myIntArray = new int[5];
        int[] anotherRef = myIntArray;
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherRef) + "\n");

        anotherRef[0] = -10;
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherRef) + "\n");

        modifyIntArray(myIntArray);
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherRef) + "\n");

        anotherRef = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherRef) + "\n");

        modifyIntArray(myIntArray);
        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherRef) + "\n");
    }

    public static void modifyIntArray(int[] array) {
        array[0] = -100;
    }

}
