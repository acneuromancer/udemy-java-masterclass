package section5_controlflow;

public class PaintJob {

    public static void main(String[] args) {
        System.out.println(getBucketCount(3.26, 0.75));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }

        double areaOfWall = width * height;
        int bucketsNeeded = (int) Math.ceil(areaOfWall/areaPerBucket);
        int bucketsNeededToBuy = bucketsNeeded - extraBuckets;

        if (bucketsNeededToBuy > 0) {
            return bucketsNeededToBuy;
        } else {
            return 0;
        }
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        return getBucketCount(width, height, areaPerBucket, 0);
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        int bucketsNeeded = (int) Math.ceil(area/areaPerBucket);

        return bucketsNeeded;
    }

}
