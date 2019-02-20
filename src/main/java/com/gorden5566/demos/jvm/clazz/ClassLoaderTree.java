package com.gorden5566.demos.jvm.clazz;

/**
 * @author gorden5566
 * @date 2019-02-20
 */
public class ClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTree.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.toString());
            classLoader = classLoader.getParent();
        }
    }
}
