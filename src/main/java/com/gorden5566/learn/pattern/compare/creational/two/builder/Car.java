package com.gorden5566.learn.pattern.compare.creational.two.builder;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Car implements ICar {

    /**
     * 汽车引擎
     */
    private String engine;

    /**
     * 汽车车轮
     */
    private String wheel;

    public Car(String engine, String wheel) {
        this.engine = engine;
        this.wheel = wheel;
    }

    @Override
    public String getWheel() {
        return null;
    }

    @Override
    public String getEngine() {
        return null;
    }

    @Override
    public String toString() {
        return "车的轮子是：" + wheel + "\n车的引擎是：" + engine;
    }
}
