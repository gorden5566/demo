package com.gorden5566.learn.pattern.command.demo.receiver;

public class ConcreteReceiver1 extends Receiver {
    @Override
    public void doSomething() {
        System.out.println("ConcreteReceiver1 doSomething");
    }
}
