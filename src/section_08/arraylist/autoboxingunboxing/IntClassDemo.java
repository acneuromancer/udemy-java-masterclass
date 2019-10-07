package section_08.arraylist.autoboxingunboxing;

import java.util.ArrayList;

class IntClass {
    private int myIntValue;

    public IntClass(int myIntValue) {
        this.myIntValue = myIntValue;
    }

    public int getMyIntValue() {
        return myIntValue;
    }

    public void setMyIntValue(int myIntValue) {
        this.myIntValue = myIntValue;
    }

}

public class IntClassDemo {

    public static void main(String[] args) {
        // ArrayList<int> myIntArrayList = new ArrayList<int>(); - Type argument cannot be of primitive type.
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));
        intClassArrayList.add(new IntClass(-1));
        intClassArrayList.add(new IntClass(108));
        intClassArrayList.add(new IntClass(510));

        for (int i=0; i<intClassArrayList.size(); i++) {
            System.out.print(intClassArrayList.get(i).getMyIntValue() + " ");
        }
    }

}
