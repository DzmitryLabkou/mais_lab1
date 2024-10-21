package org.example.service;

import org.example.entity.Array;
import org.example.exceptions.InvalidArrayFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ArrayFileReaderTest {

    @Test
    public void testReadArrayFromFileValidData() throws InvalidArrayFormatException {
        ArrayFileReader reader = new ArrayFileReader();
        String filePath = "src/test/resources/data/validData.txt";

        List<Array> arrays = reader.readArraysFromFile(filePath);
        int[] expectedArray = {1, 2, 3};

        Assert.assertEquals(arrays.size(), 1);
        Assert.assertEquals(arrays.get(0).getElements(), expectedArray);
    }

    @Test(expectedExceptions = InvalidArrayFormatException.class)
    public void testReadArrayFromFileInvalidData() throws InvalidArrayFormatException {
        ArrayFileReader reader = new ArrayFileReader();
        String filePath = "src/test/resources/data/invalidData.txt";

        reader.readArraysFromFile(filePath);
    }

    @Test(expectedExceptions = InvalidArrayFormatException.class)
    public void testReadArrayFromFileEmptyFile() throws InvalidArrayFormatException {
        ArrayFileReader reader = new ArrayFileReader();
        ClassLoader classLoader = getClass().getClassLoader();
        String filePath = "src/test/resources/data/emptyFile.txt";

        reader.readArraysFromFile(filePath);
    }

    @Test
    public void testReadArrayFromFileNegativeNumbers() throws InvalidArrayFormatException {
        ArrayFileReader reader = new ArrayFileReader();
        ClassLoader classLoader = getClass().getClassLoader();
        String filePath = "src/test/resources/data/negativeNumbers.txt";

        List<Array> arrays = reader.readArraysFromFile(filePath);
        int[] expectedArray = {-1, -2, -3};

        Assert.assertEquals(arrays.size(), 1);
        Assert.assertEquals(arrays.get(0).getElements(), expectedArray);
    }
}
