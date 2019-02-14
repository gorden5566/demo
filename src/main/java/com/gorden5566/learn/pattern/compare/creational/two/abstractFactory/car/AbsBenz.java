package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car;

import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.ICar;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public abstract class AbsBenz implements ICar {
    private final static String BENZ_BAND = "奔驰汽车";

    @Override
    public String getBand() {
        return BENZ_BAND;
    }

    /**
     * 汽车的型号
     *
     * @return
     */
    @Override
    public abstract String getModel();
}
