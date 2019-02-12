package com.gorden5566.learn.pattern.proxy.dynamic.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    /**
     * 被代理的对象
     */
    private Object target = null;

    /**
     * 通过构造函数传递一个对象
     *
     * @param target
     */
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 代理方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行被代理的方法
        return method.invoke(this.target, args);

    }
}
