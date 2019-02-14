package com.gorden5566.learn.pattern.manual.template.demo;

public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("ConcreteClass1 doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("ConcreteClass1 doAnything");
    }
}
