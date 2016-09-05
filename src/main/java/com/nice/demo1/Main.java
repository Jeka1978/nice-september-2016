package com.nice.demo1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

/**
 * Created by Jeka on 05/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();

        Random random = new Random();
        int i = random.nextInt(10);

        String s = JOptionPane.showInputDialog("give me your number");
        System.out.println("s = " + s);

    }
}
