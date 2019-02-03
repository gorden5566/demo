package com.gorden5566.learn.pattern.template.demo;

public abstract class AbstractClass {
    /**
     * 基本方法
     */
    protected abstract void doSomething();

    /**
     * 基本方法
     */
    protected abstract void doAnything();

    /**
     * 模板方法
     */
    public void templateMethod() {
        this.doAnything();
        this.doSomething();
    }
}
