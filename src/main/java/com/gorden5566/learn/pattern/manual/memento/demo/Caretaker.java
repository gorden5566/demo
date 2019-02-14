package com.gorden5566.learn.pattern.manual.memento.demo;

/**
 * 备忘录管理员角色
 * 用于保存状态
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
