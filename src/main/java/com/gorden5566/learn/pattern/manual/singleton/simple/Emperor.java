package com.gorden5566.learn.pattern.manual.singleton.simple;

public class Emperor {
    private static Emperor emperor = new Emperor();

    public static Emperor getInstance() {
        return emperor;
    }

    // 构造函数设置为private
    private Emperor() {
    }

    public static void say() {
        System.out.println("我就是皇帝某某某......");
    }
}
