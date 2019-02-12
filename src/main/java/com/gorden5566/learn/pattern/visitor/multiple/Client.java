package com.gorden5566.learn.pattern.visitor.multiple;

import com.gorden5566.learn.pattern.visitor.simple.employee.CommonEmployee;
import com.gorden5566.learn.pattern.visitor.simple.employee.Employee;
import com.gorden5566.learn.pattern.visitor.simple.employee.Manager;
import com.gorden5566.learn.pattern.visitor.multiple.visitor.IShowVisitor;
import com.gorden5566.learn.pattern.visitor.multiple.visitor.ITotalVisitor;
import com.gorden5566.learn.pattern.visitor.multiple.visitor.ShowVisitor;
import com.gorden5566.learn.pattern.visitor.multiple.visitor.TotalVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Client {
    public static void main(String[] args) {
        IShowVisitor showVisitor = new ShowVisitor();
        ITotalVisitor totalVisitor = new TotalVisitor();

        for (Employee employee : mockEmployee()) {
            employee.accept(showVisitor);
            employee.accept(totalVisitor);
        }

        showVisitor.report();
        totalVisitor.totalSalary();
    }

    public static List<Employee> mockEmployee() {
        List<Employee> empList = new ArrayList<Employee>();
        //产生张三这个员工
        CommonEmployee zhangSan = new CommonEmployee();
        zhangSan.setJob("编写Java程序，绝对的蓝领、苦工加搬运工");
        zhangSan.setName("张三");
        zhangSan.setSalary(1800);
        zhangSan.setSex(Employee.MALE);
        empList.add(zhangSan);

        //产生李四这个员工
        CommonEmployee liSi = new CommonEmployee();
        liSi.setJob("页面美工，审美素质太不流行了！");
        liSi.setName("李四");
        liSi.setSalary(1900);
        liSi.setSex(Employee.FEMALE);
        empList.add(liSi);

        //再产生一个经理
        Manager wangWu = new Manager();
        wangWu.setName("王五");
        wangWu.setPerformance("基本上是负值，但是我会拍马屁呀");
        wangWu.setSalary(18750);
        wangWu.setSex(Employee.MALE);
        empList.add(wangWu);
        return empList;
    }
}
