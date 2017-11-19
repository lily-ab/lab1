/**
 * "Example" class Person.
 * Made to display working of the sorting of the elements of "MyArrayList" collection after adding new element.
 */
package com.lab1;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * Overrides the "Comparable" method to alphabetically sort persons by the names
     * @param p specifies the "Person" object whose name is compared with the other object's name.
     * @return <tt>0</tt> if the argument is a string, lexically equal to a given object's name;
     * @return <tt>a positive number</tt> if the argument is a string, lexically lower to a given object's name;
     * @return <tt>a negative number</tt> if the argument is a string, lexically higher to a given object's name;
     */
    @Override
    public int compareTo(Person p) {
        return name.compareTo(p.getName());
    }
}
