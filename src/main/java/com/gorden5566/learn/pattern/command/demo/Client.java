package com.gorden5566.learn.pattern.command.demo;

import com.gorden5566.learn.pattern.command.demo.command.Command;
import com.gorden5566.learn.pattern.command.demo.command.ConcreteCommand1;
import com.gorden5566.learn.pattern.command.demo.receiver.ConcreteReceiver1;
import com.gorden5566.learn.pattern.command.demo.receiver.Receiver;

public class Client {
    public static void main(String[] args) {
        //首先声明调用者Invoker
        Invoker invoker = new Invoker();
        //定义接收者
        Receiver receiver = new ConcreteReceiver1();
        //定义一个发送给接收者的命令
        Command command = new ConcreteCommand1(receiver);
        //把命令交给调用者去执行
        invoker.setCommand(command);
        invoker.action();
    }
}
