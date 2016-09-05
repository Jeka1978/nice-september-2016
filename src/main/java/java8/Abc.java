package java8;

/**
 * Created by Jeka on 05/09/2016.
 */
public class Abc implements A,B{

    static {
        System.out.println("I'm static");
    }

    {
        System.out.println("I'm initializer");
    }

    public Abc() {
        System.out.println("emmpty constr");
    }

    public Abc(int x) {
        System.out.println("Constructor");
    }

    @Override
    public void x() {
        B.super.x();
    }
}
