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
            System.out.println("\n 1 - Add new person \n 2 - Show the list of persons \n 3 - Remove person" +
                    "\n 4 - Get person \n 5 - Set person \n 6 - Get list of persons in the interval" +
                    "\n 7 - Get index of person \n 8 - Get the last index of person \n 9 - Choose emptiness of the list" +
                    "\n 10 - Check the availability \n 11 - Exit");
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
                case "3":
                    System.out.println("Enter index: ");
                    String ind=read.next();
                    if(isDigit(ind)){
                        persons.remove(Integer.parseInt(ind));
                    }
                    else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "4":
                    System.out.println("Enter index: ");
                    ind=read.next();
                    if(isDigit(ind)){
                        persons.get(Integer.parseInt(ind));
                    }
                    else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "5":
                    System.out.println("Enter index: ");
                    ind=read.next();
                    if(isDigit(ind)){
                        System.out.println("Name: ");
                        String name1=read.next();
                        System.out.println("Age: ");
                        age=read.next();
                        if(isDigit(age)){
                            persons.set(Integer.parseInt(ind),new Person(name1,Integer.parseInt(age)));
                        }
                        else {
                            System.out.println("Entered value  is not a digit");
                        }
                    }
                    else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "6":
                    System.out.println("Enter first index: ");
                    ind=read.next();
                    if(isDigit(ind)){
                        System.out.println("Enter last index: ");
                        String ind1=read.next();
                        if(isDigit(ind1)){
                            MyList<Person> newList=persons.subList(Integer.parseInt(ind),Integer.parseInt(ind1));
                            for(int i=0;i<newList.size();i++){
                                System.out.println(newList.get(i).getName() + " " + newList.get(i).getAge());
                            }
                        }
                        else {
                            System.out.println("Entered value  is not a digit");
                        }
                    }
                    else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "7":
                        System.out.println("Name: ");
                        name=read.next();
                        System.out.println("Age: ");
                         age=read.next();
                        if(isDigit(age)){
                            persons.indexOf(new Person(name,Integer.parseInt(age)));
                        }
                        else {
                            System.out.println("Entered value  is not a digit");
                        }
                    break;
                case  "11":
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
