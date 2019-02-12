package com.gorden5566.learn.pattern.visitor.simple.employee;

import com.gorden5566.learn.pattern.visitor.simple.visitor.IVisitor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public abstract class Employee {
    public static final int MALE = 0;
    public static final int FEMALE = 1;

    private String name;
    private int salary;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * 我允许一个访问者访问
     *
     * @param visitor
     */
    public abstract void accept(IVisitor visitor);
}
