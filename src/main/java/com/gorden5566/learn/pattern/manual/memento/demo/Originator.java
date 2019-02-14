package com.gorden5566.learn.pattern.manual.memento.demo;

/**
 * 发起人角色
 * 用于创建备忘录、恢复备忘录
 */
public class Originator {
    //内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 创建一个备忘录
     *
     * @return
     */
    public Memento createMemento() {
        return new Memento(this.state);
    }

    /**
     * 恢复一个备忘录
     *
     * @param memento
     */
    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
