package com.gorden5566.learn.pattern.manual.strategy.demo.strategy;

public class ConcreteStrategy1 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("ConcreteStrategy1 doSomething");
    }
}
