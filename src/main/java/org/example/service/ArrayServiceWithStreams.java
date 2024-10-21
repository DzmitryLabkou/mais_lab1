package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Array;
import java.util.Arrays;
import java.util.OptionalInt;

public class ArrayServiceWithStreams {
    private static final Logger logger = LogManager.getLogger(ArrayServiceWithStreams.class);

    // Поиск минимального значения
    public OptionalInt findMin(Array array) {
        logger.info("Поиск минимального значения в массиве: {}", array);
        return Arrays.stream(array.getElements()).min();
    }

    // Поиск максимального значения
    public OptionalInt findMax(Array array) {
        logger.info("Поиск максимального значения в массиве: {}", array);
        return Arrays.stream(array.getElements()).max();
    }

    // Замена элементов по условию (например, если элемент меньше 5, заменяем на 0)
    public void replaceIfLessThan(Array array, int threshold, int newValue) {
        if (array == null || array.getElements() == null) {
            logger.error("Массив пуст или не инициализирован");
            return;
        }

        logger.info("Замена элементов массива по условию: меньше {}, заменяем на {}", threshold, newValue);
        logger.debug("Исходный массив: {}", Arrays.toString(array.getElements()));

        int[] modifiedArray = Arrays.stream(array.getElements())
                .map(el -> el < threshold ? newValue : el)
                .toArray();

        array.setElements(modifiedArray);

        logger.info("Массив после замены элементов: {}", Arrays.toString(array.getElements()));
    }

    // Определение среднего значения
    public double findAverage(Array array) {
        return Arrays.stream(array.getElements()).average().orElse(0.0);
    }

    // Определение суммы элементов массива
    public int findSum(Array array) {
        int sum = Arrays.stream(array.getElements()).sum();
        logger.info("Сумма элементов массива: {}", sum);
        return sum;
    }

    // Определение числа положительных элементов
    public long countPositive(Array array) {
        return Arrays.stream(array.getElements()).filter(el -> el > 0).count();
    }

    // Определение числа отрицательных элементов
    public long countNegative(Array array) {
        return Arrays.stream(array.getElements()).filter(el -> el < 0).count();
    }
}
