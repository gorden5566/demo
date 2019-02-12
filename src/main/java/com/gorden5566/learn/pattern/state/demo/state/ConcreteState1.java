package com.gorden5566.learn.pattern.state.demo.state;

import com.gorden5566.learn.pattern.state.demo.Context;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class ConcreteState1 extends State {
    @Override
    public void handle1() {
        System.out.println("ConcreteState1 handle1");
    }

    @Override
    public void handle2() {
        System.out.println("ConcreteState1 handle2");
        //设置当前状态为stat2
        super.context.setCurrentState(Context.STATE2);
        //过渡到state2状态，由Context实现
        super.context.handle2();
    }
}
