package com.gorden5566.learn.pattern.manual.observer.demo.subject;

public class ConcreteSubject extends Subject {

    public void doSomething() {
        super.notifyObservers();
    }
}
