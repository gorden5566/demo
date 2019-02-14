package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class BenzSuv extends AbsBenz {
    private final static String G_SERIES = "G系列SUV";

    @Override
    public String getModel() {
        return G_SERIES;
    }
}
