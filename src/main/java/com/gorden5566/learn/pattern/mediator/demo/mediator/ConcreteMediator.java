package com.gorden5566.learn.pattern.mediator.demo.mediator;

public class ConcreteMediator extends Mediator {
    @Override
    public void doSomething1() {
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        super.c2.selfMethod2();
        super.c1.selfMethod1();
    }
}
