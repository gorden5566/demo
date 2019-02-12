package com.gorden5566.learn.pattern.state.demo.state;

import com.gorden5566.learn.pattern.state.demo.Context;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public abstract class State {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 行为1
     */
    public abstract void handle1();

    /**
     * 行为2
     */
    public abstract void handle2();
}
