package com.gorden5566.learn.pattern.compare.behavioral.two.strategy;

import com.gorden5566.learn.pattern.compare.behavioral.two.strategy.strategy.AdultWork;
import com.gorden5566.learn.pattern.compare.behavioral.two.strategy.strategy.ChildWork;
import com.gorden5566.learn.pattern.compare.behavioral.two.strategy.strategy.OldWork;

/**
 * 环境角色，负责算法的替换
 *
 * @author gorden5566
 * @date 2019-02-14
 */
public class Client {
    public static void main(String[] args) {
        //定义一个环境角色
        Context context = new Context();

        System.out.println("====儿童的主要工作=====");
        context.setWorkMethod(new ChildWork());
        context.work();

        System.out.println("====成年人的主要工作=====");
        context.setWorkMethod(new AdultWork());
        context.work();

        System.out.println("====老年人的主要工作=====");
        context.setWorkMethod(new OldWork());
        context.work();
    }
}
