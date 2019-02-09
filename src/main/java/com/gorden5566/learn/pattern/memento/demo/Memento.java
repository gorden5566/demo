package com.gorden5566.learn.pattern.memento.demo;

/**
 * 备忘录角色，用于保存状态
 */
public class Memento {
    private String state = "";

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
