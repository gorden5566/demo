package com.gorden5566.learn.pattern.manual.factory.abstractFactory.demo.product;

public abstract class AbstractProductB {
    /**
     * 产品共有的方法
     */
    public void shareMethod() {
        System.out.println("share method from B!");
    }

    /**
     * 每个产品相同的方法，不同的实现
     */
    public abstract void doSomething();
}
