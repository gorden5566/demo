package com.gorden5566.learn.pattern.strategy.simple;

import com.gorden5566.learn.pattern.strategy.simple.strategy.IStrategy;

public class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        this.strategy.operate();
    }
}
