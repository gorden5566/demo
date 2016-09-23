package com.gorden5566.demos.pattern.observer.impl;

import com.gorden5566.demos.pattern.observer.Observer;
import com.gorden5566.demos.pattern.observer.Subject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    private static final Log logger = LogFactory.getLog(ConcreteSubject.class);

    private List<Observer> observers = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String info) {
        for (Observer observer : observers) {
            observer.update(info);
        }
    }
}
