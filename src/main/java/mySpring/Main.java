package mySpring;

/**
 * Created by Jeka on 08/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        Elf elf = ObjectFactory.getInstance().createObject(Elf.class);
        System.out.println("elf = " + elf);
    }
}
