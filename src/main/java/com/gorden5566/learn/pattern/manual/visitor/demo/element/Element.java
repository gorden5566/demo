package com.gorden5566.learn.pattern.manual.visitor.demo.element;

import com.gorden5566.learn.pattern.manual.visitor.demo.visitor.IVisitor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public abstract class Element {
    /**
     * 定义业务逻辑
     */
    public abstract void doSomething();

    /**
     * 允许谁来访问
     *
     * @param visitor
     */
    public abstract void accept(IVisitor visitor);
}
