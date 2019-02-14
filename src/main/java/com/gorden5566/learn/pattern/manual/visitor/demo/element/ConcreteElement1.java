package com.gorden5566.learn.pattern.manual.visitor.demo.element;

import com.gorden5566.learn.pattern.manual.visitor.demo.visitor.IVisitor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class ConcreteElement1 extends Element {
    @Override
    public void doSomething() {
        System.out.println("ConcreteElement1 doSomething");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
