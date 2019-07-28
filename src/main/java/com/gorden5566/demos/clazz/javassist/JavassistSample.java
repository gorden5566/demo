package com.gorden5566.demos.clazz.javassist;

import javassist.*;

import java.lang.reflect.Method;

/**
 * @author gorden5566
 * @date 2019/07/28
 */
public class JavassistSample {
    public static void main(String[] args) throws Exception {
//        test1();
//        test2();
        test3();
    }

    /**
     * modify method
     *
     * @throws Exception
     */
    private static void test1() throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.gorden5566.demos.clazz.javassist.Hello");
        CtMethod m = cc.getDeclaredMethod("say");
        m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.say();
    }

    /**
     * add constructor
     */
    private static void test2() throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.gorden5566.demos.clazz.javassist.Hello");

        CtConstructor constructor = CtNewConstructor.make("public Hello(int a) {}", cc);
        cc.addConstructor(constructor);

        Class<?> clazz = cc.toClass();
        Hello h = (Hello) clazz.newInstance();
        h.say();
    }

    /**
     * add method
     *
     * @throws Exception
     */
    private static void test3() throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.gorden5566.demos.clazz.javassist.Hello");

        CtMethod method = CtNewMethod.make("public void test() {System.out.println(\"this is a test\");}", cc);
        cc.addMethod(method);

        Class<?> clazz = cc.toClass();
        Hello h = (Hello) clazz.newInstance();

        Method testMethod = clazz.getMethod("test");
        testMethod.invoke(h);
    }
}
