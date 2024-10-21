package org.example.service;

import java.util.ArrayList;
import java.util.List;
import org.example.entity.Array;
import org.example.exceptions.InvalidArrayFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ArrayFileReader {
    private static final Logger logger = LogManager.getLogger(ArrayFileReader.class);
    private static final Pattern VALID_PATTERN = Pattern.compile("^-?\\d+(,\\s*-?\\d+)*$");

    public List<Array> readArraysFromFile(String filePath) throws InvalidArrayFormatException {
        List<Array> arrays = new ArrayList<>();

        try {
            // Читаем все строки из файла
            List<String> lines = Files.lines(Paths.get(filePath)).collect(Collectors.toList());

            for (String line : lines) {
                line = line.trim();
                logger.info("Чтение строки: {}", line);

                // Проверка на соответствие валидному формату
                if (isValidLine(line)) {
                    int[] elements = parseLineToArray(line);
                    logger.info("Корректная строка найдена: {}", line);
                    arrays.add(new Array(elements)); // добавляем корректный массив в список
                } else {
                    logger.warn("Некорректная строка: {}", line);
                }
            }
        } catch (IOException e) {
            logger.error("Ошибка чтения файла: {}", filePath, e);
            throw new InvalidArrayFormatException("Ошибка чтения файла: " + filePath, e);
        }

        if (arrays.isEmpty()) {
            throw new InvalidArrayFormatException("Не найдена корректная строка в файле: " + filePath);
        }

        return arrays; // возвращаем список массивов
    }

    // Метод для проверки валидности строки
    private boolean isValidLine(String line) {
        return VALID_PATTERN.matcher(line).matches();
    }

    // Метод для преобразования строки в массив целых чисел
    private int[] parseLineToArray(String line) throws InvalidArrayFormatException {
        try {
            return Arrays.stream(line.split(",\\s*"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            logger.error("Ошибка парсинга строки: {}", line, e);
            throw new InvalidArrayFormatException("Некорректная строка: " + line, e);
        }
    }

}