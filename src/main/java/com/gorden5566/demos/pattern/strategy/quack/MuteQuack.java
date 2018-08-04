package com.gorden5566.demos.pattern.strategy.quack;

import com.gorden5566.demos.pattern.strategy.QuackBehavior;

/**
 * @author gorden5566
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}