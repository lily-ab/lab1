/**
 * The "MyArrayList" class.
 * Resizable-array implementation of the <tt>MyList</tt> interface.
 * The implimentation of the data structure, which has type of a dynamic array.
 * Implements all optional MyList operations, and permits all elements, including
 * <tt>null</tt>.  In addition to implementing the <tt>List</tt> interface,
 * this class provides methods to manipulate the size of the array that is
 * used internally to store the list.
 * @author Lilia Abdullina
 * @version 1
 */
package com.lab1;

import java.util.*;

public class MyArrayList<T> implements MyList<T>, Comparable<T>{
    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the MyArrayList is the length of this array buffer.
     */
    private T[] array;
    /**
     * The size of the MyArrayList (the number of elements it contains).
     */
    private int size=0;

    public MyArrayList() {
        try{
            array=(T[])new Object[0];
        }
        catch(ClassCastException ex){
            ex.getMessage();
        }
    }

    /**
     * Constructs an empty massive with the specified initial size.
     * @param  initialSize  the initial sizeof the list
     * @throws IllegalArgumentException if the specified initial capacity is negative
     * @throws ClassCastException in case of incorrect types conversion
     */
    public MyArrayList(int initialSize) {
        if (initialSize > 0) {
            try{
                this.array = (T[])new Object[initialSize];
                size=initialSize;
            }
            catch (ClassCastException ex){ex.getMessage();}
        } else if (initialSize == 0) {
            this.array = null;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialSize);
        }
    }

    /**
     * Constructs an array containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param t the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     * @throws ClassCastException in case of incorrect types conversion
     */
    public MyArrayList(Collection<? extends T> t) {
        try{array = (T[])t.toArray();}
        catch (ClassCastException ex){ex.getMessage();}
        if ((size=t.size()) != 0) {
            if (array.getClass() != Object[].class)
                array = (T[])Arrays.copyOf(array, size(), Object[].class);
        } else {
            this.array = null;
        }
    }

    /**
     * Returns the number of elements in this array.
     * @return the number of elements in this array
     */
    @Override
    public int size(){
        return size;
    }
    @Override
    public void add(T t){
        try{
            T[] temp=array;
            array=(T[])new Object[temp.length+1];
            System.arraycopy(temp,0,array,0,temp.length);
            array[array.length-1]=t;
            size++;
        }
        catch (ClassCastException e){
            e.getMessage();
        }
    }

    @Override
    public void add(int index, T t){
        checkIndex(index);
        try{
            array=Arrays.copyOf(array,size+1);
            System.arraycopy(array, index, array, index + 1,size - index);
            array[index]=t;
            size++;
        }
        catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     * @param obj element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    @Override
    public boolean contains(Object obj){
        return indexOf(obj) >= 0;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T get(int index){
        checkIndex(index);
        return array[index];
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object obj){
        if (obj == null) {
            for (int i = 0; i < size; i++)
                if (array[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (obj.equals(array[i]))
                    return i;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object obj){
        if (obj == null) {
            for (int i = size-1; i >= 0; i--)
                if (array[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (obj.equals(array[i]))
                    return i;
        }
        return -1;
    }

    /**
     * Returns <tt>true</tt> if this array contains no elements.
     * @return <tt>true</tt> if this array contains no elements
     */
    @Override
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException
     *  @throws ClassCastException
     */
    @Override
    public void remove(int index){
        checkIndex(index);
        try{
            T[] temp=array;
            array=(T[])new Object[temp.length-1];
            System.arraycopy(temp,0,array, 0, index);
            System.arraycopy(temp,index+1,array, index,temp.length-index-1);
            size--;
        }
        catch (ClassCastException e){
            e.getMessage();
        }
    }

    /**
    * Returns a portion of this list between the specified
    * {@code first}, and {@code last}, exclusive.
     *  @throws IndexOutOfBoundsException
     * @throws IllegalArgumentException
     */
    @Override
    public MyArrayList<T> subList(int first, int last){
        checkIndex(first);
        checkIndex(last);
        if(first>last) throw new IllegalArgumentException("Negative range");
        MyArrayList<T> newArray=new MyArrayList<T>(last-first);
        System.arraycopy(array,first,newArray,0,last-first);
        return newArray;
    }

    // @Override
    public Iterator iterator() {
        return new ListArrayIterator<T>(array);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        final int expectedModCount = size;
        try {
            Arrays.sort((T[]) array, 0, size, c);
        }
        catch (ClassCastException ex){ex.getMessage();}
        if (size != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        size++;
    }

    /**
     * @throws IndexOutOfBoundsException in case of negative index or
     * exceeding the upper limit of the array
     * @param index
     */
    public void checkIndex(int index){
        if(index<0 || index>=size()){
            throw new IndexOutOfBoundsException("Incorrect index");
        }
    }


    @Override
    public int compareTo(T o) {
        return 0;
    }
}
