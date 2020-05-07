package com.gorden5566.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author gorden5566
 * @date 2020/05/07
 */
public class CountingSortTest {

    @Test
    public void countingSort() {
        int[] a = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        ArrayUtils.printArray(a);
        new CountingSort().countingSort(a);
        ArrayUtils.printArray(a);
    }
}