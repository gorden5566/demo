package com.gorden5566.learn.pattern.mediator.demo.colleague;

import com.gorden5566.learn.pattern.mediator.demo.mediator.Mediator;

public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
