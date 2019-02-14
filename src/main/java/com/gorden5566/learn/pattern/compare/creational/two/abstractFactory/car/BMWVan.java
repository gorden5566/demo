package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class BMWVan extends AbsBMW {
    private final static String SEVEN_SERIES = "7系列车型商务车";

    @Override
    public String getModel() {
        return SEVEN_SERIES;
    }
}
