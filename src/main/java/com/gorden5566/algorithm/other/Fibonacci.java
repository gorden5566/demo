package com.gorden5566.algorithm.other;

/**
 * @author gorden5566
 * @date 2019-03-07
 */
public class Fibonacci {
    public static int Fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int n0 = 0;
        int n1 = 1;

        int index = 2;
        while (index < n) {
            int temp = n1;

            // 向后移动
            n1 = n0 + n1;
            n0 = temp;

            index++;
        }

        return n0 + n1;
    }
}
