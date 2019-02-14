package com.gorden5566.learn.pattern.compare.structural.one.decorator;

import com.gorden5566.learn.pattern.compare.structural.one.IRunner;
import com.gorden5566.learn.pattern.compare.structural.one.Runner;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Client {
    public static void main(String[] args) {
        //定义运动员
        IRunner liu = new Runner();
        //对其功能加强
        liu = new RunnerWithJet(liu);
        //看看它的跑步情况如何
        System.out.println("===增强后的运动员的功能===");
        liu.run();
    }
}
