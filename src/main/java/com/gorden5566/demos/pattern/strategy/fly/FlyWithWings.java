package com.gorden5566.demos.pattern.strategy.fly;

import com.gorden5566.demos.pattern.strategy.FlyBehavior;

/**
 * @author gorden5566
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}