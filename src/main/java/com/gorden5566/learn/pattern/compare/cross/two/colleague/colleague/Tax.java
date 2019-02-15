package com.gorden5566.learn.pattern.compare.cross.two.colleague.colleague;

import com.gorden5566.learn.pattern.compare.cross.two.colleague.AbsColleague;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.AbsMediator;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.ITax;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Tax extends AbsColleague implements ITax {
    public Tax(AbsMediator mediator) {
        super(mediator);
    }

    @Override
    public void raise() {
        super.mediator.up(this);
    }

    @Override
    public void drop() {
        super.mediator.down(this);
    }
}
