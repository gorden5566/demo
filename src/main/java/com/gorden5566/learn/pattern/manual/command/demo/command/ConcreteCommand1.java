package com.gorden5566.learn.pattern.manual.command.demo.command;

import com.gorden5566.learn.pattern.manual.command.demo.receiver.Receiver;

public class ConcreteCommand1 extends Command {

    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}
