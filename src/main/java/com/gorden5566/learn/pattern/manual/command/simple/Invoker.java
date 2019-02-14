package com.gorden5566.learn.pattern.manual.command.simple;

import com.gorden5566.learn.pattern.manual.command.simple.command.Command;

public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
