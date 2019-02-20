package com.gorden5566.demos.jvm.clazz;

import com.gorden5566.demos.util.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gorden5566
 * @date 2019-02-20
 */
public class FileSystemClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
        InstantiationException, NoSuchMethodException, InvocationTargetException {

        String path = Utils.getPackageRootPath(FileSystemClassLoaderTest.class);

        FileSystemClassLoader classLoader = new FileSystemClassLoader(path);

        // 加载类
        Class<?> clazz = classLoader.findClass("com.gorden5566.demos.jvm.clazz.FileSystemClassLoaderTest");
        Object object = clazz.newInstance();

        // 测试方法调用
        Method testShowName = clazz.getMethod("testShowName", String.class);
        testShowName.invoke(object, "哈哈哈哈");

        // 不是同一个类加载器加载的
        System.out.println(clazz.equals(FileSystemClassLoaderTest.class));

        FileSystemClassLoaderTest test = new FileSystemClassLoaderTest();

        System.out.println(object instanceof FileSystemClassLoaderTest);
        System.out.println(test instanceof FileSystemClassLoaderTest);
    }

    public void testShowName(String name) {
        System.out.println("show name: " + name);
    }
}
