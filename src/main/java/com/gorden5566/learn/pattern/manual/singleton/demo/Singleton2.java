package com.gorden5566.learn.pattern.manual.singleton.demo;

public class Singleton2 {
    // 注意这里必须定义为volatile, 防止并发时获取到未初始化完的实例
    private static volatile Singleton2 singleton = null;

    private Singleton2() {
    }

    public static Singleton2 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton2.class) {
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }

        return singleton;
    }
}
