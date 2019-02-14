package com.gorden5566.learn.pattern.manual.state.demo;

import com.gorden5566.learn.pattern.manual.state.demo.state.ConcreteState1;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Client {
    public static void main(String[] args) {
        //定义环境角色
        Context context = new Context();
        //初始化状态
        context.setCurrentState(new ConcreteState1());
        //行为执行
//        context.handle1();
        context.handle2();
    }
}
