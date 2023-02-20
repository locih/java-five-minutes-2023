public class Four {

    static class A {
        void hello() {
            System.out.println("Hello!");
        }
    }

    static class B {
        void hello() {
            System.out.println("Hi!");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        Object o = a;
        B b = (B) o;
        b.hello();
    }
}
