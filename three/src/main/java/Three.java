package main.java;

public class Three {

    private record Point(int x, int y) {}

    private enum Choice {
        YES,
        NO;
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        if (p instanceof Record) {
            System.out.println("Record!");
        }
        Choice c = Choice.YES;
        if (c instanceof Object) {
            System.out.println("Object!");
        }
    }
}
