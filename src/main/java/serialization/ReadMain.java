package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

/**
 * Created by Jeka on 05/09/2016.
 */
public class ReadMain {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("C:\\temp\\persons\\a.srl");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person person = (Person) ois.readObject();
        System.out.println("person = " + person);
    }
}
