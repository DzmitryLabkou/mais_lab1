package org.example.service;

import org.example.entity.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySorter {
    private static final Logger logger = LogManager.getLogger(ArraySorter.class);

    // Пузырьковая сортировка
    public void bubbleSort(Array array) {
        logger.info("Начало пузырьковой сортировки: {}", array);
        int[] elements = array.getElements();
        boolean swapped;
        for (int i = 0; i < elements.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < elements.length - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    // Меняем элементы местами
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Если элементы не менялись местами, сортировка завершена
        }
        logger.info("Пузырьковая сортировка завершена: {}", array);
    }

    // Сортировка вставками
    public void insertionSort(Array array) {
        logger.info("Начало сортировки вставками: {}", array);
        int[] elements = array.getElements();
        for (int i = 1; i < elements.length; i++) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j = j - 1;
            }
            elements[j + 1] = key;
        }
        logger.info("Сортировка вставками завершена: {}", array);
    }

    // Сортировка выбором
    public void selectionSort(Array array) {
        logger.info("Начало сортировки выбором: {}", array);
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[minIndex]) {
                    minIndex = j;
                }
            }
            // Меняем минимальный элемент с текущим
            int temp = elements[minIndex];
            elements[minIndex] = elements[i];
            elements[i] = temp;
        }
        logger.info("Сортировка выбором завершена: {}", array);
    }
}
