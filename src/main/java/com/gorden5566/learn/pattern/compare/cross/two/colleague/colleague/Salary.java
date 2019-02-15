package com.gorden5566.learn.pattern.compare.cross.two.colleague.colleague;

import com.gorden5566.learn.pattern.compare.cross.two.colleague.AbsColleague;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.AbsMediator;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.ISalary;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Salary extends AbsColleague implements ISalary {
    public Salary(AbsMediator mediator) {
        super(mediator);
    }

    @Override
    public void increaseSalary() {
        super.mediator.up(this);
    }

    @Override
    public void decreaseSalary() {
        super.mediator.down(this);
    }
}
