package com.gorden5566.learn.pattern.state.simple.state;

import com.gorden5566.learn.pattern.state.simple.Context;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class OpeningState extends LiftState {
    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.CLOSING_STATE);
        //动作委托为CloseState来执行
        super.context.getLiftState().close();
    }

    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }

    @Override
    public void run() {
        //do nothing;
    }

    @Override
    public void stop() {
        //do nothing;
    }
}
