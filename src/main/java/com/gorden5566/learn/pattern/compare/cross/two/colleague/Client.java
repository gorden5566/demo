package com.gorden5566.learn.pattern.compare.cross.two.colleague;

import com.gorden5566.learn.pattern.compare.cross.two.colleague.colleague.Position;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.colleague.Salary;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.colleague.Tax;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.media.Mediator;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Client {
    public static void main(String[] args) {
        //定义中介者
        Mediator mediator = new Mediator();

        //定义各个同事类
        IPosition position = new Position(mediator);
        ISalary salary = new Salary(mediator);
        ITax tax = new Tax(mediator);

        //职位提升了
        System.out.println("===职位提升===");
        position.promote();
    }
}
