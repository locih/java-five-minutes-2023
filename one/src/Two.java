public class Two {

    public static int getI() {
        return 5;
    }

    public static void main(String[] args) {
        var x;
        if (getI() > 1) {
            x = 1;
        }
        else {
            x = 0.0;
        }

        System.out.println(x);
    }
}

