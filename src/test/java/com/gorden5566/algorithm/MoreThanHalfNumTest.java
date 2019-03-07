package com.gorden5566.algorithm;

import com.gorden5566.algorithm.other.MoreThanHalfNum;
import org.junit.Test;

/**
 * @author gorden5566
 * @date 2019-03-07
 */
public class MoreThanHalfNumTest {

    @Test
    public void moreThanHalfNum_Solution() {
//        int[] array = {1,2,3,2,2,2,5,4,2};
        int[] array = {1,2,3,2,4,2,5,2,3};

        int result = MoreThanHalfNum.MoreThanHalfNum_Solution(array);
        System.out.println(result);
    }
}