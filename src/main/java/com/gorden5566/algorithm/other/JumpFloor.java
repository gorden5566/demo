package com.gorden5566.algorithm.other;

/**
 * 题目描述
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class JumpFloor {
    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        int n1 = 1, n2 =2;
        int index = 3;
        while (index < target) {
            int temp = n2;
            n2 = n2 + n1;
            n1 = temp;
            index++;
        }

        return n1 + n2;
    }
}
