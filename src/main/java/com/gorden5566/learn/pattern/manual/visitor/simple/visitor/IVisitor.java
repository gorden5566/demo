package com.gorden5566.learn.pattern.manual.visitor.simple.visitor;

import com.gorden5566.learn.pattern.manual.visitor.simple.employee.CommonEmployee;
import com.gorden5566.learn.pattern.manual.visitor.simple.employee.Manager;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public interface IVisitor {
    /**
     * 首先，定义我可以访问普通员工
     *
     * @param commonEmployee
     */
    void visit(CommonEmployee commonEmployee);

    /**
     * 其次，定义我还可以访问部门经理
     *
     * @param manager
     */
    void visit(Manager manager);
}
