package com.gorden5566.demos.algorithm;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BubbleSortTest {
    private static Logger logger = LoggerFactory.getLogger(BubbleSortTest.class);

    private Comparator c;
    @Before
    public void setup() {
        c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1 - (Integer) o2;
            }
        };
    }

    @Test
    public void test1() {
        Integer[] srcArr = new Integer[] {3,5,2,1,7,9,6,8,4,0};

        Long start = System.currentTimeMillis();
        BubbleSort.sort(srcArr, 0, srcArr.length, c);
        Long cost = System.currentTimeMillis() - start;
        logger.info("cost time: " + cost);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < srcArr.length; ++i) {
            sb.append(srcArr[i]).append(" ");
        }
        logger.info(sb.toString());
    }

    @Test
    public void test2() {
        List<Integer> srcList = Arrays.asList(3,5,2,1,7,9,6,8,4,0);

        Long start = System.currentTimeMillis();
        BubbleSort.sort(srcList, c);
        Long cost = System.currentTimeMillis() - start;
        logger.info("cost time: " + cost);

        StringBuffer sb = new StringBuffer();
        for (Integer num : srcList) {
            sb.append(num).append(" ");
        }
        logger.info(sb.toString());
    }
}