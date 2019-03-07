package com.gorden5566.algorithm;

import com.gorden5566.algorithm.other.FindNumInArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author gorden5566
 * @date 2019-03-06
 */
public class FindNumInArrayTest {

    @Test
    public void testFind1() {
        int[][] array = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
        };

        boolean result = FindNumInArray.find(7, array);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testFind2() {
        int[][] array = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
        };

        boolean result = FindNumInArray.find(5, array);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testFind3() {
        int[][] array = {};

        boolean result = FindNumInArray.find(5, array);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testFind4() {
        int[][] array = null;

        boolean result = FindNumInArray.find(5, array);
        Assert.assertEquals(false, result);
    }
}