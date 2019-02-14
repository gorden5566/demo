package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class BMWSuv extends AbsBMW {
    private final static String X_SERIES = "X系列车型SUV";

    @Override
    public String getModel() {
        return X_SERIES;
    }
}
