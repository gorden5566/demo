package com.gorden5566.learn.pattern.manual.visitor.simple.employee;

import com.gorden5566.learn.pattern.manual.visitor.simple.visitor.IVisitor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Manager extends Employee {

    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
