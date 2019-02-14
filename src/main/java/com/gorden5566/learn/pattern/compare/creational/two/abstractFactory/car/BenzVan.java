package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class BenzVan extends AbsBenz {
    private final static String R_SERIES = "R系列商务车";

    @Override
    public String getModel() {
        return R_SERIES;
    }
}
