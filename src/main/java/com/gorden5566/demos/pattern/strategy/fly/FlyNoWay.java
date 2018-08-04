package com.gorden5566.demos.pattern.strategy.fly;

import com.gorden5566.demos.pattern.strategy.FlyBehavior;

/**
 * @author gorden5566
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}