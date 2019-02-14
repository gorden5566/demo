package com.gorden5566.learn.pattern.manual.bridge.demo;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor imp) {
        super(imp);
    }

    @Override
    public void request() {
        super.request();
        super.getImp().doAnything();
    }
}
