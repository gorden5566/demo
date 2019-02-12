package com.gorden5566.learn.pattern.visitor.multiple.visitor;

import com.gorden5566.learn.pattern.visitor.simple.visitor.IVisitor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public interface IShowVisitor extends IVisitor {

    /**
     * 展示报表
     */
    void report();
}
