public class One {

    public static void swap(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
    }

    public static void swap(Integer o1, Integer o2) {
        Integer tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void main(String[] args) {
        int i = 1;
        int j = 42;
        swap(i, j);
        System.out.printf("i = %d, j = %d%n", i, j);

        Integer i1 = 1;
        Integer j1 = 42;
        swap(i1, j1);
        System.out.printf("i = %d, j = %d%n", i1, j1);
    }
}
