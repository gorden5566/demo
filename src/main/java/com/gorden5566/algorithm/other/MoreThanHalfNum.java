package com.gorden5566.algorithm.other;

/**
 * 题目描述
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class MoreThanHalfNum {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null) {
            return 0;
        }

        int target = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                target = array[i];
            }

            if (target == array[i]) {
                count++;
            } else {
                count--;
            }
        }

        if (checkMoreThanHalf(array, target)) {
            return target;
        }

        return 0;
    }

    private static boolean checkMoreThanHalf(int[] array, int target) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                times++;
            }
        }
        if (times > array.length >> 1) {
            return true;
        }
        return false;
    }
}
