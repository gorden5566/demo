package com.gorden5566.demos.pattern.strategy.duck;

import com.gorden5566.demos.pattern.strategy.Duck;
import com.gorden5566.demos.pattern.strategy.fly.FlyWithWings;
import com.gorden5566.demos.pattern.strategy.quack.Quack;

/**
 * @author gorden5566
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}