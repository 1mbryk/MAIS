package entity;

import java.util.ArrayList;
import java.util.Arrays;
import exceptions.*;

public class Array {
    private Integer[] array;
    private int size;

    public Array(Integer[] array) {
        this.array = array;
        this.size = array.length;
    }

    public Array(Array array) {
        this.array = array.array.clone();
        this.size = array.size;
    }

    public Integer get(int index){
        return array[index];
    }

    public void set(int index, Integer value){
        array[index] = value;
    }

    public int size(){
        return size;
    }
    public Array sort(String method){
        return this.sort(method, false);
    }

    public Array sort(String method, boolean inplace){ // "quick" - quicksort, "bubble" - bubblesort

        ArrayList<String> methods = new ArrayList<>(Arrays.asList("quick", "bubble"));
        if (!methods.contains(method)){
            throw new WrongSortMethodException("There is no \""+method+"\" sort method!");
        }

        Array clone = new Array(this);
        switch (method){
            case "quick":
                this.quickSort(0, size -1);
                break;
            case "bubble":
                this.bubbleSort();
                break;
//            case "insertion":

        }
        if (!inplace){
            Array temp = new Array(this);
            this.array = clone.array;
            return temp;

        }
        return this;
    }

    private int partition(int low, int high)
    {
        // Choosing the pivot
        int pivot = array[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (array[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    public void quickSort(int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
    private void bubbleSort(){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void swap(int i, int j){
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        String str = "[";
        for (Integer integer : array) {
            str += integer + " ";
        }
        str += "\b]";
        return str;
    }
}
