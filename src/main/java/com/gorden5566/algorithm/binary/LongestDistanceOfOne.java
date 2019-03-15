package com.gorden5566.algorithm.binary;

/**
 * @author gorden5566
 * @date 2019-03-12
 */
public class LongestDistanceOfOne {
    public static void main(String[] args) {
        test(22);
        test(5);
        test(6);
        test(8);

        test(1);
        test(3);
        test(5);
        test(6);
        test(11);
        test(0);
        test(-1);
        test(-2);
        test(-3);
        test(-100);
    }

    public static void test(int num) {
        System.out.println("[" + num + "]: " + Integer.toBinaryString(num));
        System.out.println("longest distance of one: " + longestDistanceOfOne(num));
    }

    /**
     * 计算二进制中相邻1的最大距离
     *
     * @param num
     * @return
     */
    public static int longestDistanceOfOne(int num) {
        // 计算1的个数
        if (countOfOne(num) <= 1) {
            return 0;
        }

        // 找到第一个1
        int n = num;
        while (n != 0 && (n & 1) == 0) {
            n = n >>> 1;
        }

        // 计算最大长度
        int longestDistance = 0;
        while (n != 0) {
            // 走一步
            n = n >>> 1;
            int distance = 1;

            // 找下一个1
            while (n != 0 && (n & 1) == 0) {
                n = n >>> 1;
                distance++;
            }

            if (longestDistance < distance) {
                longestDistance = distance;
            }
        }

        return longestDistance;
    }

    /**
     * 计算二进制中1的位数
     *
     * @param num
     * @return
     */
    public static int countOfOne(int num) {
        if (num == 0) {
            return 0;
        }

        int countOfOne = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                countOfOne++;
            }

            num = num >>> 1;
        }

        return countOfOne;
    }
}
