public class Three {

    private final int i;

    Three(int i) {
        this.i = i;
    }

    Three() {
        this(42);
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.i);
    }
}
