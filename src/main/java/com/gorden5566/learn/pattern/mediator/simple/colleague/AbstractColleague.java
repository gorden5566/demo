package com.gorden5566.learn.pattern.mediator.simple.colleague;

import com.gorden5566.learn.pattern.mediator.simple.mediator.AbstractMediator;

public class AbstractColleague {
    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
