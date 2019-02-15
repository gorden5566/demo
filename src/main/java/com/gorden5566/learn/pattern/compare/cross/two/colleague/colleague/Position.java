package com.gorden5566.learn.pattern.compare.cross.two.colleague.colleague;

import com.gorden5566.learn.pattern.compare.cross.two.colleague.AbsColleague;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.AbsMediator;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.IPosition;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Position extends AbsColleague implements IPosition {
    public Position(AbsMediator mediator) {
        super(mediator);
    }

    @Override
    public void promote() {
        super.mediator.up(this);
    }

    @Override
    public void demote() {
        super.mediator.down(this);
    }
}
