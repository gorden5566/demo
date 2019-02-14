package com.gorden5566.learn.pattern.compare.structural.one.proxy;

import com.gorden5566.learn.pattern.compare.structural.one.IRunner;

import java.util.Random;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class RunnerAgent implements IRunner {

    private IRunner runner;

    public RunnerAgent(IRunner runner) {
        this.runner = runner;
    }


    @Override
    public void run() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            System.out.println("代理人同意安排运动员跑步");
            runner.run();
        } else {
            System.out.println("代理人心情不好，不安排运动员跑步");
        }
    }
}
