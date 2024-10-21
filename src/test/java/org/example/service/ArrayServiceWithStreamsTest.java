package org.example.service;

import org.example.entity.Array;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.OptionalInt;

public class ArrayServiceWithStreamsTest {
    private Array array;
    private ArrayServiceWithStreams service;

    @BeforeMethod
    public void setUp() {
        array = new Array(new int[]{5, 3, -8, 4, 2});
        service = new ArrayServiceWithStreams();
    }

    @Test
    public void testFindMin() {
        OptionalInt min = service.findMin(array);
        Assert.assertEquals(min.getAsInt(), -8);
    }

    @Test
    public void testFindMax() {
        OptionalInt max = service.findMax(array);
        Assert.assertEquals(max.getAsInt(), 5);
    }

    @Test
    public void testReplaceIfLessThan() {
        service.replaceIfLessThan(array, 3, 0);
        int[] expected = {5, 3, 0, 4, 0};
        Assert.assertEquals(array.getElements(), expected);
    }

    @Test
    public void testFindAverage() {
        double avg = service.findAverage(array);
        Assert.assertEquals(avg, 1.2);
    }

    @Test
    public void testFindSum() {
        int sum = service.findSum(array);
        Assert.assertEquals(sum, 6);
    }

    @Test
    public void testCountPositive() {
        long count = service.countPositive(array);
        Assert.assertEquals(count, 4);
    }

    @Test
    public void testCountNegative() {
        long count = service.countNegative(array);
        Assert.assertEquals(count, 1);
    }

}
