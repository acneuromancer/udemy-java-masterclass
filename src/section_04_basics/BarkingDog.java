package section_04_basics;

public class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        } else if (barking) {
            if (hourOfDay < 8 || hourOfDay > 22) {
                return true;
            }
        }

       return false;
    }

}
