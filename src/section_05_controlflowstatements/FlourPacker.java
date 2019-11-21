package section_05_controlflowstatements;

public class FlourPacker {

    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 11));
        System.out.println(canPack(-3, 2, 11));
        System.out.println(canPack(0, 5, 5));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        if ((int) goal/5 < bigCount) {
            return ((int) goal/5) * 5 + smallCount >= goal;
        }

        return bigCount * 5 + smallCount >= goal;
    }

}
