package com.gorden5566.learn.pattern.adapter.demo;

public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.doSomething();
    }
}
