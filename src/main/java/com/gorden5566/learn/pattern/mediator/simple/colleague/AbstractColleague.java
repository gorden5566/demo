package com.gorden5566.learn.pattern.mediator.simple.colleague;

import com.gorden5566.learn.pattern.mediator.simple.mediator.AbstractMediator;

public class AbstractColleague {
    /**
     * 通过这个中介者进行沟通
     */
    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
