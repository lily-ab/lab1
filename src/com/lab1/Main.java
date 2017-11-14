package com.lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag=true;
        Scanner read=new Scanner(System.in);
        MyList<Person> persons=new MyArrayList<Person>();
        persons.add(new Person("John",25));
        persons.add(new Person("Mary",16));
        persons.add(new Person("Anna",25));
        persons.add(new Person("Zayn",35));

        while(flag){
            System.out.println("\n 1 - Add new person \n 2 - Show the list of persons \n 3 - Exit");
            String choice=read.next();
            switch(choice){
                case "1":
                    System.out.println("Name: ");
                    String name=read.next();
                    System.out.println("Age: ");
                    String age=read.next();
                    if(isDigit(age)){
                        persons.add(new Person(name,Integer.parseInt(age)));
                    }
                    else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "2":
                    for(int i=0;i<persons.size();i++){
                        System.out.println(persons.get(i).getName() + " " + persons.get(i).getAge());
                    }
                break;
                case  "3":
                    flag=false;
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }

    }
    public static boolean isDigit(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
