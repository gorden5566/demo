package com.gorden5566.learn.pattern.strategy.simple.strategy;

public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙， 让吴国太给孙权施加压力");
    }
}
