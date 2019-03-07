package com.gorden5566.algorithm;

import com.gorden5566.algorithm.other.RotateArray;
import org.junit.Test;

/**
 * @author gorden5566
 * @date 2019-03-07
 */
public class RotateArrayTest {

    @Test
    public void testMinNumberInRotateArray() {
//        int[] array = {3,4,5,1,2};
//        int[] array = {};
//        int[] array = {1,2,3,4,5};
        int[] array = {2,4,5,5,6,1,1,2};
        System.out.println(RotateArray.minNumberInRotateArray(array));
    }
}