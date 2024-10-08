package service;
import entity.Array;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.stream.IntStream;
import java.util.function.Supplier;
import java.util.OptionalInt;
import java.util.OptionalDouble;

public class ArrayFunctionality {
    private static final Logger logger = LogManager.getLogger(ArrayFunctionality.class);

    public Integer min(Array array){
        Integer min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        logger.info("minimum value is: {}", min);
        return min;
    }

    public int minIntStream(Array array){
        Supplier<IntStream> supplier = () -> IntStream.of(array.getArray());
        OptionalInt min=supplier.get().min();
        return min.isPresent()? min.getAsInt():0;
    }

    public Integer max(Array array){
        Integer max = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        logger.info("maximum value is: {}", max);
        return max;
    }

    public int maxIntStream(Array array){
        Supplier<IntStream> supplier = () -> IntStream.of(array.getArray());
        OptionalInt max=supplier.get().max();
        return max.isPresent()?max.getAsInt():0;
    }

    public Integer countPositive(Array array){
        Integer count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0){
                count++;
            }
        }
        logger.info("amount of positive values is: {}", count);
        return count;
    }

    public Integer countNegative(Array array){
        Integer count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0){
                count++;
            }
        }
        logger.info("amount of negative values is: {}", count);
        return count;
    }

    public Integer sum(Array array){
        Integer sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        logger.info("sum is: {}", sum);
        return sum;
    }

    public int sumIntStream(Array array){
        Supplier<IntStream> supplier = () -> IntStream.of(array.getArray());
        return supplier.get().sum();
    }

    public double average(Array array){
        Supplier<IntStream> supplier = () -> IntStream.of(array.getArray());
        OptionalDouble average = supplier.get().average();
        return average.isPresent()? average.getAsDouble() : 0.0;
    }
    // ?????????????????
    public Integer getMedian(Array array){
        Integer median;
        Sort sort = new Sort();
        Array sortedArray = sort.sort(array, "quick");
        median = array.get(sortedArray.size()/2);
        logger.info("median is: {}", median);
        return median;
    }
}
