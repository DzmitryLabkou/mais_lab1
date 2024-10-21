package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.example.service.ArrayFileReader;
import org.example.service.ArrayProcessingService;
import org.example.service.ArraySorter;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Начало работы.");
        // Пример вызова методов
        String filePath = "src/main/resources/data/data.txt"; // путь к файлу с данными
        ArrayFileReader fileReader = new ArrayFileReader();
        ArraySorter arraySorter = new ArraySorter();

        ArrayProcessingService processingService = new ArrayProcessingService(fileReader, arraySorter);
        // Обрабатываем массив (чтение из файла, сортировка и т.д.)
        processingService.processArray(filePath, "bubble");
    }
}