package com.gorden5566.learn.pattern.manual.singleton.demo;

public class Singleton {
    private static final Singleton singleton = new Singleton();

    // 限制产生多个对象
    private Singleton() {
    }

    // 通过该方法获取实例
    public static Singleton getInstance() {
        return singleton;
    }

    // 类中其他方法，尽量是static
    public static void doSomething() {

    }
}
