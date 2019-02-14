package com.gorden5566.learn.pattern.manual.state.simple.state;

import com.gorden5566.learn.pattern.manual.state.simple.Context;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class ClosingState extends LiftState {
    @Override
    public void close() {
        System.out.println("电梯门关闭...");
    }

    @Override
    public void open() {
        //置为敞门状态
        super.context.setLiftState(Context.OPENING_STATE);
        super.context.getLiftState().open();
    }

    @Override
    public void run() {
        //设置为运行状态
        super.context.setLiftState(Context.RUNNING_STATE);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        //设置为停止状态
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.getLiftState().stop();
    }
}
