package com.gorden5566.demos.algorithm;

/**
 * @author gorden5566
 * @date 2019/09/03
 */
public class GCD {
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }

    public static int gcdN(int[] data, int length) {
        if (length == 1) {
            return data[0];
        }

        return gcd(data[length - 1], gcdN(data, length - 1));
    }

    public static void main(String[] args) {
        int gcd = gcd(2, 3);
        System.out.println(gcd);

        int[] data = {6, 9, 12};

        int gcdN = gcdN(data, data.length);
        System.out.println(gcdN);
    }
}
