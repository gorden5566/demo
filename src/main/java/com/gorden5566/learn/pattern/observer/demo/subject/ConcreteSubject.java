package com.gorden5566.learn.pattern.observer.demo.subject;

public class ConcreteSubject extends Subject {

    public void doSomething() {
        super.notifyObservers();
    }
}
