package com.gorden5566.demos.pattern.observer;

import com.gorden5566.demos.pattern.observer.impl.ConcreteObserver;
import com.gorden5566.demos.pattern.observer.impl.ConcreteSubject;
import org.junit.Test;

public class ObserverTest {
    @Test
    public void test() {
        Long observerNum = 10L;
        Subject subject = new ConcreteSubject();

        for (long i = 0; i < observerNum; ++i) {
            Observer observer = new ConcreteObserver(i);
            subject.attach(observer);
        }

        subject.notify("Observer Pattern");
    }
}