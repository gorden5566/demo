package com.gorden5566.learn.pattern.manual.proxy.dynamic.demo.proxy;

import com.gorden5566.learn.pattern.manual.proxy.dynamic.demo.target.Subject;

public class SubjectDynamicProxy extends DynamicProxy {
    public static <T> T newProxyInstance(Subject subject) {
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        MyInvocationHandler handler = new MyInvocationHandler(subject);
        return newProxyInstance(classLoader, interfaces, handler);
    }
}
