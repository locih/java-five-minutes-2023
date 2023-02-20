record MyRecord(int i) {}

public class One {

    MyRecord record;

    private void test() {
        System.out.println(record.toString());
    }

    public static void main(String[] args) {
        One one = new One();
        one.test();
    }
}
