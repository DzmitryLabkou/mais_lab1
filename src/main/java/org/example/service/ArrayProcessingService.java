package org.example.service;

import java.util.List;
import org.example.entity.Array;
import org.example.exceptions.InvalidArrayFormatException;
import org.example.exceptions.InvalidSortAlgorithmException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayProcessingService {
    private static final Logger logger = LogManager.getLogger(ArrayProcessingService.class);
    private final ArrayFileReader fileReader;
    private final ArraySorter arraySorter;

    public ArrayProcessingService(
            ArrayFileReader fileReader,
            ArraySorter arraySorter
    ) {
        this.fileReader = fileReader;
        this.arraySorter = arraySorter;
    }

    public void processArray(String filePath, String sortAlgorithm) {
        try {
            // Чтение всех массивов из файла
            List<Array> arrays = fileReader.readArraysFromFile(filePath);

            // Обрабатываем каждый массив
            for (Array array : arrays) {
                logger.info("Массив успешно прочитан из файла: {}", array);

                // Выполнение сортировки на основе выбранного алгоритма
                switch (sortAlgorithm.toLowerCase()) {
                    case "bubble":
                        logger.info("Выполняется пузырьковая сортировка.");
                        arraySorter.bubbleSort(array);
                        break;
                    case "insertion":
                        logger.info("Выполняется сортировка вставками.");
                        arraySorter.insertionSort(array);
                        break;
                    case "selection":
                        logger.info("Выполняется сортировка выбором.");
                        arraySorter.selectionSort(array);
                        break;
                    default:
                        logger.error("Некорректный алгоритм сортировки: {}", sortAlgorithm);
                        throw new InvalidSortAlgorithmException("Некорректный алгоритм сортировки: " + sortAlgorithm);
                }

                logger.info("Отсортированный массив: {}", array);
            }

        } catch (InvalidArrayFormatException e) {
            logger.error("Ошибка при обработке массива из файла: {}", e.getMessage());
        }
    }

}