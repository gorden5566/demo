package com.gorden5566.learn.pattern.manual.mediator.demo;

import com.gorden5566.learn.pattern.manual.mediator.demo.colleague.ConcreteColleague1;
import com.gorden5566.learn.pattern.manual.mediator.demo.colleague.ConcreteColleague2;
import com.gorden5566.learn.pattern.manual.mediator.demo.mediator.ConcreteMediator;
import com.gorden5566.learn.pattern.manual.mediator.demo.mediator.Mediator;

public class Client {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 c2 = new ConcreteColleague2(mediator);

        mediator.setC1(c1);
        mediator.setC2(c2);

//        c1.selfMethod1();
        c1.depMethod1();

//        c2.selfMethod2();
        c2.depMethod2();
    }
}
