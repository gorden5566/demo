package com.gorden5566.learn.pattern.manual.strategy.simple.strategy;

public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开绿灯,放行！ ");
    }
}
