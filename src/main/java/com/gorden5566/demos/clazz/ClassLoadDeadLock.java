package com.gorden5566.demos.clazz;

import java.util.concurrent.TimeUnit;

/**
 * @author gorden5566
 * @date 2020/04/27
 */
public class ClassLoadDeadLock {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                B.check();
            }
        }, "B").start();

        A.check();
    }

    private static class A {
        static {
            check();
        }

        public static void check() {
            // 这里触发B类的加载
            B b = new B();
            sleep();
        }
    }

    private static class B {
        static {
            check();
        }

        public static void check() {
            sleep();
            // 这里触发A类的加载
            A a = new A();
        }
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
