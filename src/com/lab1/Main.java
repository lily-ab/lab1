package com.lab1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
//        MyArrayList<String> arr=new MyArrayList<>();
//        arr.add("aaa");
//        arr.add("bbb");
//        arr.add("zzz");
//        arr.add("ccc");
//        System.out.println(arr.size());
//        for(int i=0;i<arr.size();i++){
//            System.out.println(arr.get(i));
//        }
//        arr.add(2,"ttt");
//        arr.remove(2);
//        for(int i=0;i<arr.size();i++){
//            System.out.println(arr.get(i));
//        }
//        MyArrayList<String> arr1=new MyArrayList<>();
//        arr1.add("56");
//        arr1.add("47");
//        MyArrayList<String> arr3;
//        System.out.println(arr.contains("aaa"));
//        ArrayList<String> ar=new ArrayList<>();
//        ArrayList<String> ar2;


        MyArrayList<Person> persons=new MyArrayList<Person>();

        persons.add(new Person("John",25));
        persons.add(new Person("Mary",16));
        persons.add(new Person("Anna",25));
        persons.add(new Person("Zayn",35));
        for (Person p: persons ) {
            System.out.println(p.getName() + " " + p.getAge());
        }
    }
}
