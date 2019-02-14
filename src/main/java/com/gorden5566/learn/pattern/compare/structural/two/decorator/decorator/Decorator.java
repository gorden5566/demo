package com.gorden5566.learn.pattern.compare.structural.two.decorator.decorator;

import com.gorden5566.learn.pattern.compare.structural.two.Swan;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Decorator implements Swan {

    private Swan swan;

    public Decorator(Swan swan) {
        this.swan = swan;
    }

    @Override
    public void fly() {
        swan.fly();
    }

    @Override
    public void cry() {
        swan.cry();
    }

    @Override
    public void desAppearance() {
        swan.desAppearance();
    }
}
