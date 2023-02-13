public class Four {

    static int test(boolean b, boolean c) {
        final int i;
        if (b) {
            if (c) {
                throw new IllegalStateException();
            } else {
                i = 5;
            }
        } else {
            if (c) {
                return 42;
            }
            i = 10;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(test(false, true));
    }
}


