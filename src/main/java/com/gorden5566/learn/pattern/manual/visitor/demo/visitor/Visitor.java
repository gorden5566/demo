package com.gorden5566.learn.pattern.manual.visitor.demo.visitor;

import com.gorden5566.learn.pattern.manual.visitor.demo.element.ConcreteElement1;
import com.gorden5566.learn.pattern.manual.visitor.demo.element.ConcreteElement2;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Visitor implements IVisitor {
    @Override
    public void visit(ConcreteElement1 element1) {
        element1.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 element2) {
        element2.doSomething();
    }
}
