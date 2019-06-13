package section8.arraylist.autoboxingunboxing;

import java.util.ArrayList;

public class AutoboxingUnboxing {

    public static void main(String[] args) {

        // The long way with unnecessary boxing.
        System.out.println("The long way:");
        Integer integer = new Integer(54); // Unnecessary boxing.
        System.out.println(integer.intValue());

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            intArrayList.add(Integer.valueOf(i)); // Unnecessary boxing (autoboxing).
        }

        for (int i = 0; i < intArrayList.size(); i++) {
            System.out.println(i + " -> " + intArrayList.get(i).intValue()); // Unnecessary boxing (unboxing).
        }

        // The correct way using autoboxing and unboxing of Java.
        System.out.println("\nThe correct way:");
        Integer myIntValue = 56; // at compile time is converted to Integer myInvalue = Integer.valueOf(56);
        System.out.println("myIntValue = " + myIntValue);
        int myInt = myIntValue; // myInt = myIntValue.intValue();
        System.out.println("myInt " + myInt + "\n");

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
//        for (double d = 0.0; d <= 10.0; d += 0.5) {
//            myDoubleValues.add(Double.valueOf(d));
//        }
//
//        for (int i = 0; i < myDoubleValues.size(); i++) {
//            System.out.println(i + " --> " + myDoubleValues.get(i).doubleValue());
//        }

        for (double d = 0.0; d <= 10.0; d += 0.5) {
            myDoubleValues.add(d);
        }

        for (int i = 0; i < myDoubleValues.size(); i++) {
            System.out.println(i + " --> " + myDoubleValues.get(i));
        }
    }

}
