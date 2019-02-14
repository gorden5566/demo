package com.gorden5566.learn.pattern.manual.facade.demo;

import com.gorden5566.learn.pattern.manual.facade.demo.sub.ClassA;
import com.gorden5566.learn.pattern.manual.facade.demo.sub.ClassB;
import com.gorden5566.learn.pattern.manual.facade.demo.sub.ClassC;

public class Facade {
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();

    public void methodA() {
        a.doSomethingA();
    }

    public void methodB() {
        b.doSomethingB();
    }

    public void methodC() {
        c.doSomethingC();
    }
}
