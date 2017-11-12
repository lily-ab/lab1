package com.lab1;

import java.util.Comparator;

class PersonComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        return p1.getName().compareTo(p2.getName());
    }
}
