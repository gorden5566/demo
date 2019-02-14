package com.gorden5566.learn.pattern.manual.mediator.demo.colleague;

import com.gorden5566.learn.pattern.manual.mediator.demo.mediator.Mediator;

public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod2() {
        System.out.println("selfMethod2");
    }

    public void depMethod2() {
        super.mediator.doSomething2();
    }
}
