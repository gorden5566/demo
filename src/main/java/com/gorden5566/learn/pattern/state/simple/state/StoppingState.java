package com.gorden5566.learn.pattern.state.simple.state;

import com.gorden5566.learn.pattern.state.simple.Context;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class StoppingState extends LiftState {
    @Override
    public void close() {
        //do nothing;
    }

    @Override
    public void open() {
        super.context.setLiftState(Context.OPENING_STATE);
        super.context.getLiftState().open();
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.RUNNING_STATE);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了...");
    }
}
