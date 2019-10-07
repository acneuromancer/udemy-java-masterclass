package section_05;

public class ParsingValuesFromString {

    public static void main(String[] args) {
        String numberAsString = "2018";
        System.out.println("numberAsString = " + numberAsString);

        int number = Integer.parseInt(numberAsString);
        System.out.println("number = " + number);

        numberAsString += 1;
        number += 1;
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number = " + number);

        numberAsString = "3.838339292";
        double doubleNumber = Double.parseDouble(numberAsString);
        System.out.println("doubleNumber = " + doubleNumber);

        // numberAsString = "2.33838383a";
        // doubleNumber = Double.parseDouble(numberAsString); - NumberFormatException would be thrown
    }

}
