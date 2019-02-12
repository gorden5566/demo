package com.gorden5566.learn.pattern.proxy.dynamic.demo.target;

public class RealSubject implements Subject {
    @Override
    public void doSomething(String str) {
        System.out.println("do something!---->" + str);
    }
}
