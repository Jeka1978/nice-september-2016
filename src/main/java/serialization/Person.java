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
    private transient int creditCard;
}






