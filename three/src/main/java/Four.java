package main.java;

public class Four {

    private static abstract class Foo {
        abstract Foo m(Foo f);

        abstract String greet();
    }

    private static abstract class Bar extends Foo {}

    private static class Baz1 extends Bar {

        @Override
        Foo m(Foo f) {
            return f;
        }

        @Override
        String greet() {
            return "hi";
        }
    }

    private static class Baz2 extends Bar {

        @Override
        Foo m(Foo f) {
            return this;
        }

        @Override
        String greet() {
            return "hello";
        }
    }

    public static void main(String[] args) {
        Foo baz1 = new Baz1();
        Foo baz2 = new Baz2();
        System.out.println(baz1.m(baz2).greet());
    }
}
