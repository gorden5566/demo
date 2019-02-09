package com.gorden5566.learn.pattern.memento.demo;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();

        // 创建备忘录
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        // 恢复备忘录
        originator.restoreMemento(caretaker.getMemento());
    }
}
