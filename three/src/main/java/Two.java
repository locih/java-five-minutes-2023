package foo.bar;

public class Two {

    public static void main(String[] args) {
        C c = new C();
        c.m();
    }
}


//-------------------------------//

package foo.bar.baz;

class C {
    public void m() {
        System.out.println("Hello!");
    }
}
