package com.gorden5566.learn.pattern.state.simple.state;

import com.gorden5566.learn.pattern.state.simple.Context;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class RunningState extends LiftState {
    @Override
    public void close() {
        //do nothing
    }

    @Override
    public void open() {
        //do nothing
    }

    @Override
    public void run() {
        System.out.println("电梯上下运行...");
    }

    @Override
    public void stop() {
        //环境设置为停止状态
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.getLiftState().stop();
    }
}
