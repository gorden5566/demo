package com.gorden5566.learn.pattern.proxy.dynamic.demo;

import com.gorden5566.learn.pattern.proxy.dynamic.demo.proxy.DynamicProxy;
import com.gorden5566.learn.pattern.proxy.dynamic.demo.proxy.MyInvocationHandler;
import com.gorden5566.learn.pattern.proxy.dynamic.demo.target.RealSubject;
import com.gorden5566.learn.pattern.proxy.dynamic.demo.target.Subject;

import java.lang.reflect.InvocationHandler;

public class Client {
    public static void main(String[] args) {
        //定义一个主题
        Subject subject = new RealSubject();
        //定义一个Handler
        InvocationHandler handler = new MyInvocationHandler(subject);
        //定义主题的代理
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        //代理的行为
        proxy.doSomething("Finish");
    }
}
