package com.gorden5566.leetcode.array;

/**
 * @author renjianjun
 * @date 2020/05/08
 */
public class ArrayUtils {
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
