package com.gorden5566.demos.clazz.load;

/**
 * @author gorden5566
 * @date 2020/07/03
 */
public class TestLoadClass {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = TestLoadClass.class.getClassLoader();

        // 加载并初始化A
        Class.forName("com.gorden5566.demos.clazz.load.A");

        // 加载，不初始化
        classLoader.loadClass("com.gorden5566.demos.clazz.load.B");
    }
}
