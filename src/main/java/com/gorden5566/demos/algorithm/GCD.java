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

    public static void main(String[] args) {
        int gcd = gcd(2, 3);
        System.out.println(gcd);
    }
}
