package com.gorden5566.learn.pattern.state.demo.state;

import com.gorden5566.learn.pattern.state.demo.Context;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class ConcreteState2 extends State {
    @Override
    public void handle1() {
        System.out.println("ConcreteState2 handle1");

        //设置当前状态为state1
        super.context.setCurrentState(Context.STATE1);
        //过渡到state1状态，由Context实现
        super.context.handle1();
    }

    @Override
    public void handle2() {
        System.out.println("ConcreteState2 handle2");
    }
}
