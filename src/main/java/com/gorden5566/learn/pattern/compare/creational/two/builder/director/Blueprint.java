package com.gorden5566.learn.pattern.compare.creational.two.builder.director;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Blueprint {
    /**
     * 车轮的要求
     */
    private String wheel;

    /**
     * 引擎的要求
     */
    private String engine;

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
