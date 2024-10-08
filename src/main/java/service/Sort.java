package service;

import entity.Array;
import exceptions.WrongSortAlgorithmException;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Sort {

    private static Logger logger = LogManager.getLogger(Sort.class);
    public Array sort (Array array, String algorithm){ // "quick" - quicksort, "bubble" - bubblesort, "insertion"

        ArrayList<String> methods = new ArrayList<>(Arrays.asList("quick", "bubble", "insertion"));
        if (!methods.contains(algorithm)) {
            logger.error("Wrong sort algorithm. Requested algorithm: {}", algorithm);
            throw new WrongSortAlgorithmException(algorithm);
        }

        logger.info("Chosen sort algorithm: {}", algorithm);
        switch (algorithm) {
            case "quick":
                this.quickSort(array, 0, array.size() - 1);
                break;
            case "bubble":
                this.bubbleSort(array);
                break;
            case "insertion":
                this.insertionSort(array);
                break;

        }
        return array;
    }

    private int partition (Array array, int low, int high){
        int pivot = array.get(high);
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {

            if (array.get(j) < pivot) {
                i++;
                array.swap(i, j);
            }
        }
        array.swap(i + 1, high);
        return (i + 1);
    }

    private void quickSort (Array array, int low, int high){
        if (low < high) {

            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array,pi + 1, high);
        }
    }

    private void bubbleSort (Array array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size()- i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }
    }

    private void insertionSort (Array array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j) < array.get(i)) {
                    int temp = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, temp);
                }
            }
        }
    }
}

