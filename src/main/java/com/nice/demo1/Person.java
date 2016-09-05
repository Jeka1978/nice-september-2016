package com.nice.demo1;

import lombok.Data;
import lombok.Getter;

/**
 * Created by Jeka on 05/09/2016.
 */
public class Person {
    private String fullName;

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}





