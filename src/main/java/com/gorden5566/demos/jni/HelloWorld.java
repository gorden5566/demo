package com.gorden5566.demos.jni;

import java.io.IOException;

/**
 * javac HelloWorld.java -h JniH
 *
 * @author gorden5566
 * @date 2019/08/12
 */
public class HelloWorld {

    public native void sayHello();

    static {
        String classPath = HelloWorld.class.getClassLoader().getResource("").getPath();
        try {
            JniUtils.addLibraryDir(classPath + "jni");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //载入本地库
        System.loadLibrary("hello");
    }

    public static void main(String[] args) {
        new HelloWorld().sayHello();
    }
}
