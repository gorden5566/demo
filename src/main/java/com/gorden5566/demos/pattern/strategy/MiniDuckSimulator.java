package com.gorden5566.demos.pattern.strategy;

import com.gorden5566.demos.pattern.strategy.duck.MallardDuck;

/**
 * @author gorden5566
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }
}