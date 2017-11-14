package com.lab1;

import java.util.Comparator;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name=name;
        this.age=age;

    }
    public String getName(){return name;}
    public int getAge(){return  age;}
    public int compareTo(Person p){

        return name.compareTo(p.getName());
    }
}
