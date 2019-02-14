package com.gorden5566.learn.pattern.compare.behavioral.two.state;

import com.gorden5566.learn.pattern.compare.behavioral.two.state.state.ChildState;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Client {
    public static void main(String[] args) {
        //定义一个普通的人
        Human human = new Human();

        //设置一个人的初始状态
        human.setHumanState(new ChildState());
        System.out.println("====儿童的主要工作=====");
        human.work();

        System.out.println("====成年人的主要工作=====");
        human.work();

        System.out.println("====老年人的主要工作=====");
        human.work();
    }
}
