package serialization;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Jeka on 05/09/2016.
 */
@Data
@AllArgsConstructor
public class Person implements Serializable{
    private String name;
    private int creditCard;

    public void doWork() {
        System.out.println(123);
    }

    public void increaseAge(int delta) {
        int x=12;
        if (x == 12) {

        }

        x=x+1;
        int y = ++x;
    }
}






