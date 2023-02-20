// какие из принтов скомпилируются?
public class Five {

    private static int i;
    private int j;

    static class C {

        void test() {
            System.out.println(i);
            System.out.println(j);
        }
    }

    class C1 {

        void test() {
            System.out.println(i);
            System.out.println(j);
        }
    }
}
