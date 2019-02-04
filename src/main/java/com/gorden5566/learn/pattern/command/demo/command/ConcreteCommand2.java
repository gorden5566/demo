package com.gorden5566.learn.pattern.command.demo.command;

import com.gorden5566.learn.pattern.command.demo.receiver.Receiver;

public class ConcreteCommand2 extends Command {

    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}
