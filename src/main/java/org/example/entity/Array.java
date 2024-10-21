package org.example.entity;

import java.util.Arrays;

public class Array {
    private int[] elements;
    private int size;

    // Конструктор для создания массива
    public Array(int[] elements) {
        this.elements = elements;
        this.size = elements.length;
    }

    // Геттер для получения массива
    public int[] getElements() {
        return elements;
    }

    // Сеттер для изменения массива
    public void setElements(int[] elements) {
        this.elements = elements;
    }

    // Метод для удобного представления массива в виде строки
    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
