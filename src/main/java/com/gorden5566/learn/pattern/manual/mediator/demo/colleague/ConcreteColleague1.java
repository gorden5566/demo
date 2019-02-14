package com.gorden5566.learn.pattern.manual.mediator.demo.colleague;

import com.gorden5566.learn.pattern.manual.mediator.demo.mediator.Mediator;

public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod1() {
        System.out.println("selfMethod1");
    }

    public void depMethod1() {
        super.mediator.doSomething1();
    }
}
