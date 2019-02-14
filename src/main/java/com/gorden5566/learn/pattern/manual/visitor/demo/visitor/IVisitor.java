package com.gorden5566.learn.pattern.manual.visitor.demo.visitor;

import com.gorden5566.learn.pattern.manual.visitor.demo.element.ConcreteElement1;
import com.gorden5566.learn.pattern.manual.visitor.demo.element.ConcreteElement2;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public interface IVisitor {

    /**
     * 访问ConcreteElement1对象
     *
     * @param element1
     */
    void visit(ConcreteElement1 element1);

    /**
     * 访问ConcreteElement2对象
     *
     * @param element2
     */
    void visit(ConcreteElement2 element2);
}
