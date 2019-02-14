package com.gorden5566.learn.pattern.manual.observer.demo;

import com.gorden5566.learn.pattern.manual.observer.demo.observer.ConcreteObserver;
import com.gorden5566.learn.pattern.manual.observer.demo.observer.Observer;
import com.gorden5566.learn.pattern.manual.observer.demo.subject.ConcreteSubject;

public class Client {
    public static void main(String[] args) {
        Observer observer = new ConcreteObserver();

        ConcreteSubject subject = new ConcreteSubject();
        subject.addObserver(observer);

        subject.doSomething();
    }
}
