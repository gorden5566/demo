package com.gorden5566.learn.pattern.bridge.demo;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class ConcreteImplementor1 implements Implementor {
    @Override
    public void doSomething() {
        System.out.println("ConcreteImplementor1 doSomething");
    }

    @Override
    public void doAnything() {
        System.out.println("ConcreteImplementor1 doAnything");
    }
}
