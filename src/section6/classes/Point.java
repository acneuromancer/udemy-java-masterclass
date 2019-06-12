package section6.classes;

public class Point {

    private int x;
    private int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Return the distance between this Point and Point(0, 0) as double
    public double distance() {
        return distance(0, 0);
    }

    // Return the distance between this Point and Point(x, y) as double
    public double distance(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    // Return the distance between this Point and another Point as double
    public double distance(Point point) {
        return distance(point.getX(), point.getY());
    }

    public static void main(String[] args) {
        Point first = new Point(6, 5 );
        Point second = new Point(3, 1);
        System.out.println("distance(0, 0 = " + first.distance());
        System.out.println("distance(second) = " + first.distance(second));
        System.out.println("distance(2, 2) =" + first.distance(2, 2));
        Point point = new Point();
        System.out.println("distance() = " + point.distance());
    }

}
