package com.gorden5566.learn.pattern.observer.demo.observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("接收到信息， 并进行处理！");
    }
}
