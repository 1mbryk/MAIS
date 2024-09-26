package entity;

import java.util.ArrayList;
import java.util.Arrays;
import exceptions.*;

public class Array {
    private Integer[] array;
    private int size;
    private int capacity;

    public Array(){
        size = 0;
        capacity = 10;
        array = new Integer[capacity];
    }
    public Array(Integer[] array) {
        this.array = array;
        this.size = array.length;
        this.capacity = array.length;
    }

    public Array(Array array) {
        this.array = array.array.clone();
        this.size = array.size;
        this.capacity = array.capacity;
    }


    public Integer get(int index){
        return array[index];
    }

    public void append(Integer... values){
        for (Integer value : values) {
            if (size == capacity) {
                resize();
            }
            array[size] = value;
            size++;
        }
    }

    public void set(int index, Integer value){
        array[index] = value;
    }

    public int size(){
        return size;
    }

    public void swap(int i, int j){
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += array[i] + ", ";
        }
        str += "\b\b]";
        return str;
    }


    private void resize(){
        capacity *= 2;
        Integer[] newArray = new Integer[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

}
