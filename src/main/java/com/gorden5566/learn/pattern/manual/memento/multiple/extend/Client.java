package com.gorden5566.learn.pattern.manual.memento.multiple.extend;

import com.gorden5566.learn.pattern.manual.memento.multiple.Originator;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 添加状态
        originator.setState1("中国");

        System.out.println(originator);

        // 备份1
        caretaker.setMemento("001", originator.createMemento());

        // 添加状态
        originator.setState1("强盛");
        originator.setState2("繁荣");

        System.out.println(originator);

        // 备份2
        caretaker.setMemento("002", originator.createMemento());

        // 恢复状态
        originator.restoreMemento(caretaker.getMemento("001"));

        System.out.println(originator);
    }
}
