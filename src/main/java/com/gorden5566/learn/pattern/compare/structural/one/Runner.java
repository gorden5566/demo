package com.gorden5566.learn.pattern.compare.structural.one;

import com.gorden5566.learn.pattern.compare.structural.one.IRunner;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Runner implements IRunner {
    @Override
    public void run() {
        System.out.println("运动员跑步：动作很潇洒");
    }
}
