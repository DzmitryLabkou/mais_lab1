package org.example.service;

import org.example.entity.Array;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArraySorterTest {
    private ArraySorter sorter;

    @BeforeMethod
    public void setUp() {
        sorter = new ArraySorter();
    }

    @Test
    public void testBubbleSort() {
        Array array = new Array(new int[]{5, 3, -8, 4, 2});
        sorter.bubbleSort(array);
        int[] expected = {-8, 2, 3, 4, 5};
        Assert.assertEquals(array.getElements(), expected);
    }

    @Test
    public void testInsertionSort() {
        Array array = new Array(new int[]{5, 3, -8, 4, 2});
        sorter.insertionSort(array);
        int[] expected = {-8, 2, 3, 4, 5};
        Assert.assertEquals(array.getElements(), expected);
    }

    @Test
    public void testSelectionSort() {
        Array array = new Array(new int[]{5, 3, -8, 4, 2});
        sorter.selectionSort(array);
        int[] expected = {-8, 2, 3, 4, 5};
        Assert.assertEquals(array.getElements(), expected);
    }

    @Test
    public void testBubbleSortWithEmptyArray() {
        Array array = new Array(new int[]{});
        sorter.bubbleSort(array);
        int[] expected = {};
        Assert.assertEquals(array.getElements(), expected);
    }

    @Test
    public void testInsertionSortWithNegativeNumbers() {
        Array array = new Array(new int[]{-5, -3, -8, -4, -2});
        sorter.insertionSort(array);
        int[] expected = {-8, -5, -4, -3, -2};
        Assert.assertEquals(array.getElements(), expected);
    }

    @Test
    public void testSelectionSortWithSameValues() {
        Array array = new Array(new int[]{1, 1, 1, 1});
        sorter.selectionSort(array);
        int[] expected = {1, 1, 1, 1};
        Assert.assertEquals(array.getElements(), expected);
    }
}