package com.gorden5566.learn.pattern.state.demo;

import com.gorden5566.learn.pattern.state.demo.state.ConcreteState1;
import com.gorden5566.learn.pattern.state.demo.state.ConcreteState2;
import com.gorden5566.learn.pattern.state.demo.state.State;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Context {

    /**
     * 定义状态
     */
    public final static State STATE1 = new ConcreteState1();
    public final static State STATE2 = new ConcreteState2();

    /**
     * 当前状态
     */
    private State currentState;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public void handle1() {
        this.currentState.handle1();
    }

    public void handle2() {
        this.currentState.handle2();
    }
}
