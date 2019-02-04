package com.gorden5566.learn.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target;

    public GamePlayIH(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        if ("login".equals(method.getName())) {
            System.out.println("----------登录预处理----------");
        }
        Object result = method.invoke(target, args);
        doAfter();
        return result;
    }

    private void doBefore() {
        System.out.println("GamePlayIH doBefore");
    }

    private void doAfter() {
        System.out.println("GamePlayIH doAfter");
    }
}
