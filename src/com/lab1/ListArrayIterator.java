package com.lab1;

import java.util.Iterator;

public class ListArrayIterator<T> implements Iterator {
    private int index=0;
    private T[] array;
    public ListArrayIterator(T[] array) {
        this.array=array;
    }
    @Override
    public boolean hasNext(){
        return index<array.length;
    }
    @Override
    public T next(){
        return array[index++];
    }
}