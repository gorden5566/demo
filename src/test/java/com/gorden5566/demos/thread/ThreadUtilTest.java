package com.gorden5566.demos.thread;

/**
 * @author gorden5566
 * @date 2019/12/20
 */
public class ThreadUtilTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        test();
    }

    public static void test() {
        System.out.println("before printStackTrace");
        ThreadUtil.printStackTrace("print current thread stack");
        System.out.println("after printStackTrace");
    }
}