package com.gorden5566.learn.pattern.manual.bridge.demo;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class ConcreteImplementor2 implements Implementor {
    @Override
    public void doSomething() {
        System.out.println("ConcreteImplementor2 doSomething");
    }

    @Override
    public void doAnything() {
        System.out.println("ConcreteImplementor2 doAnything");
    }
}
