package com.gorden5566.learn.pattern.manual.proxy.demo;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject request");
    }
}
