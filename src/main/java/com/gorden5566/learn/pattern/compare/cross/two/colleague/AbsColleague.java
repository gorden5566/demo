package com.gorden5566.learn.pattern.compare.cross.two.colleague;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public abstract class AbsColleague {
    /**
     * 每个同事类都对中介者非常了解
     */
    protected AbsMediator mediator;

    public AbsColleague(AbsMediator mediator) {
        this.mediator = mediator;
    }
}
