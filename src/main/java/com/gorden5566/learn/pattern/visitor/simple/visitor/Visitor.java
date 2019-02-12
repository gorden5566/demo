package com.gorden5566.learn.pattern.visitor.simple.visitor;

import com.gorden5566.learn.pattern.visitor.simple.employee.CommonEmployee;
import com.gorden5566.learn.pattern.visitor.simple.employee.Employee;
import com.gorden5566.learn.pattern.visitor.simple.employee.Manager;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Visitor implements IVisitor {
    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(this.getCommonEmployee(commonEmployee));
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(this.getManagerInfo(manager));
    }

    /**
     * 组装出基本信息
     *
     * @param employee
     * @return
     */
    private String getBasicInfo(Employee employee){
        String info = "姓名：" + employee.getName() + "\t";
        info = info + "性别：" + (employee.getSex() == Employee.FEMALE?"女":"男") + "\t";
        info = info + "薪水：" + employee.getSalary() + "\t";
        return info;
    }

    /**
     * 组装出部门经理的信息
     *
     * @param manager
     * @return
     */
    private String getManagerInfo(Manager manager){
        String basicInfo = this.getBasicInfo(manager);
        String otherInfo = "业绩："+manager.getPerformance() + "\t";
        return basicInfo + otherInfo;
    }

    /**
     * 组装出普通员工信息
     *
     * @param commonEmployee
     * @return
     */
    private String getCommonEmployee(CommonEmployee commonEmployee){
        String basicInfo = this.getBasicInfo(commonEmployee);
        String otherInfo = "工作："+commonEmployee.getJob()+"\t";
        return basicInfo + otherInfo;
    }
}
