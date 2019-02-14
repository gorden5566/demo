package com.gorden5566.learn.pattern.manual.memento.clone;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();

        originator.setState("初始状态...");
        System.out.println("初始状态是： "+originator.getState());

        // 建立备份
        originator.createMemento();

        originator.setState("修改后的状态...");
        System.out.println("修改后状态是： "+originator.getState());

        originator.restoreMemento();
        System.out.println("恢复后状态是： "+originator.getState());
    }
}
