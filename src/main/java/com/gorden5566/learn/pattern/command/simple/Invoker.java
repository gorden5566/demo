package com.gorden5566.learn.pattern.command.simple;

import com.gorden5566.learn.pattern.command.simple.command.Command;

public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
