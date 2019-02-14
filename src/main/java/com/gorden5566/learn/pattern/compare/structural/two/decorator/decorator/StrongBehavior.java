package com.gorden5566.learn.pattern.compare.structural.two.decorator.decorator;

import com.gorden5566.learn.pattern.compare.structural.two.Swan;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class StrongBehavior extends Decorator {
    public StrongBehavior(Swan swan) {
        super(swan);
    }

    @Override
    public void fly() {
        System.out.println("会飞行了！");
    }
}
