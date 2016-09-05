package serialization;

import lombok.SneakyThrows;

import java.io.*;

/**
 * Created by Jeka on 05/09/2016.
 */
public class WriteMain {
    public static void main(String[] args) throws IOException {
        Person aron = new Person("Aron", 123);
        File file = new File("C:\\temp\\persons\\a.srl");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(aron);
        oos.close();


    }
}
