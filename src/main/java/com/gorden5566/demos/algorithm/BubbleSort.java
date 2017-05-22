package com.gorden5566.demos.algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class BubbleSort {
    /**
     * 交换数组指定位置的值
     *
     * @param x 数组
     * @param a
     * @param b
     */
    public static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    /**
     * 对数组指定范围内的值排序
     *
     * @param x
     * @param low
     * @param high
     * @param c
     */
    public static void sort(Object[] x, int low, int high, Comparator c) {
        for (int i = low; i < high; ++i) {
            for (int j = high - 1; j > i; --j) {
                if (c.compare(x[j - 1], x[j]) > 0) {
                    swap(x, j - 1, j);
                }
            }
        }
    }

    /**
     * 对list进行排序
     *
     * @param list
     * @param c
     * @param <T>
     */
    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        Object[] x = list.toArray();
        sort(x, 0, x.length, c);
        ListIterator iter = list.listIterator();
        for (int i = 0; i < x.length; ++i) {
            iter.next();
            iter.set(x[i]);
        }
    }
}
