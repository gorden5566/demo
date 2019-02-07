package com.gorden5566.learn.pattern.strategy.demo;

import com.gorden5566.learn.pattern.strategy.demo.strategy.Strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doAnything() {
        this.strategy.doSomething();
    }
}
