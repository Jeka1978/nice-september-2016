package mySpring;

import lombok.ToString;

import java.util.Random;

/**
 * Created by Jeka on 08/09/2016.
 */
@ToString
public class Elf {

    @InjectRandomName
    private String name;

    @InjectRandomInt(min = 30, max = 50)
    private int power=22000;
    @InjectRandomInt(min = 100, max = 150)
    private int dex;


}
