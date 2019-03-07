package com.gorden5566.algorithm.other;

/**
 * 题目描述
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class JumpFloorII {

    public static int JumpFloorII(int target) {
        if (target < 1) {
            return 0;
        }

        int result = 1;
        for (int i = 1; i < target; i++) {
            result = result * 2;
        }
        return result;
    }
}
