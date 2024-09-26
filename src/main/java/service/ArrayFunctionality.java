package service;
import entity.Array;

public class ArrayFunctionality {

    public Integer min(Array array){
        Integer min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        return min;
    }

    public Integer max(Array array){
        Integer max = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return max;
    }

    public Integer countPositive(Array array){
        Integer count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0){
                count++;
            }
        }
        return count;
    }

    public Integer countNegative(Array array){
        Integer count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0){
                count++;
            }
        }
        return count;
    }

    public Integer sum(Array array){
        Integer sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return sum;
    }

    // ?????????????????
    public Integer getMedian(Array array){
        Integer median;
        Sort sort = new Sort();
        Array sortedArray = sort.sort(array, "quick");
        median = array.get(sortedArray.size()/2);
        return median;
    }
}
