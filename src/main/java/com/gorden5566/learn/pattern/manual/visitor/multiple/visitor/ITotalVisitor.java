package com.gorden5566.learn.pattern.manual.visitor.multiple.visitor;

import com.gorden5566.learn.pattern.manual.visitor.simple.visitor.IVisitor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public interface ITotalVisitor extends IVisitor {
    /**
     * 统计所有员工工资总和
     */
    void totalSalary();
}
