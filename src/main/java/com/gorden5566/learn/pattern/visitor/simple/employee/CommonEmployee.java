package com.gorden5566.learn.pattern.visitor.simple.employee;

import com.gorden5566.learn.pattern.visitor.simple.visitor.IVisitor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class CommonEmployee extends Employee {

    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
