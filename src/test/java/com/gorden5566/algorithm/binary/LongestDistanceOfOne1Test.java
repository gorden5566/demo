package com.gorden5566.algorithm.binary;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author gorden5566
 * @date 2019-03-15
 */
public class LongestDistanceOfOne1Test {

    @Test
    public void testLongestDistanceOfOne() {
        Assert.assertEquals(LongestDistanceOfOne1.longestDistanceOfOne(22), 2);
        Assert.assertEquals(LongestDistanceOfOne1.longestDistanceOfOne(5), 2);
        Assert.assertEquals(LongestDistanceOfOne1.longestDistanceOfOne(6), 1);
        Assert.assertEquals(LongestDistanceOfOne1.longestDistanceOfOne(8), 0);

        Assert.assertEquals(LongestDistanceOfOne1.longestDistanceOfOne(0), 0);

        Assert.assertEquals(LongestDistanceOfOne1.longestDistanceOfOne(-1), 1);
        Assert.assertEquals(LongestDistanceOfOne1.longestDistanceOfOne(-3), 2);
        Assert.assertEquals(LongestDistanceOfOne1.longestDistanceOfOne(-100), 3);
    }
}