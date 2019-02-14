package com.gorden5566.learn.pattern.compare.structural.one.decorator;

import com.gorden5566.learn.pattern.compare.structural.one.IRunner;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class RunnerWithJet implements IRunner {
    private IRunner runner;

    public RunnerWithJet(IRunner runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        System.out.println("加快运动员的速度：为运动员增加喷气装置");
        runner.run();
    }
}
