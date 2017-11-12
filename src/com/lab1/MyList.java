package com.lab1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public interface MyList<T> {
    void add(T t);
    void add(int index, T t);
    boolean contains(Object obj);
    T get(int index);
    void set(int index, T element);
    int indexOf(T t);
    int lastIndexOf(T t);
    boolean isEmpty();
    void remove(int index);
    void sort(Comparator<? super T> t);
    int size();
    MyArrayList<T> subList(int first, int last);
    Iterator iterator();
}
