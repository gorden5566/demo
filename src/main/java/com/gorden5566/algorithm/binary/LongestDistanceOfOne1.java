package com.gorden5566.algorithm.binary;

/**
 * @author gorden5566
 * @date 2019-03-12
 */
public class LongestDistanceOfOne1 {
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
        if (num == 0) {
            return 0;
        }

        // 转换为数组
        int bitLength = 32;
        int[] array = new int[bitLength];
        int totalCountOfOne = 0;
        for (int i = 0, compare = 1; i < bitLength; i++, compare = compare << 1) {
            // 记录当前位
            int bit = (compare & num) == 0 ? 0 : 1;
            array[i] = bit;

            // 记录1的位数
            totalCountOfOne += bit;
        }

        // 只有1个1
        if (totalCountOfOne == 1) {
            return 0;
        }

        // 找到第一个1
        int index = 0;
        while (index < bitLength && array[index] == 0) {
            index++;
        }

        // 找到最大长度
        int longestDistance = 0;
        while (index < bitLength) {
            index++;
            int distance = 1;

            // 找到下一个1
            while (index < bitLength && array[index] == 0) {
                distance++;
                index++;
            }

            // 没有找到下一个1
            if (index == bitLength) {
                break;
            }

            if (longestDistance < distance) {
                longestDistance = distance;
            }
        }

        return longestDistance;
    }
}
