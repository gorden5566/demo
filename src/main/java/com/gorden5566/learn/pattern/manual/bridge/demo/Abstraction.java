package com.gorden5566.learn.pattern.manual.bridge.demo;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public abstract class Abstraction {
    /**
     * 定义对实现化角色的引用
     */
    private Implementor imp;

    public Abstraction(Implementor imp) {
        this.imp = imp;
    }

    /**
     * 自身的行为和属性
     */
    public void request(){
        this.imp.doSomething();
    }

    /**
     * 获得实现化角色
     *
     * @return
     */
    public Implementor getImp(){
        return imp;
    }
}
