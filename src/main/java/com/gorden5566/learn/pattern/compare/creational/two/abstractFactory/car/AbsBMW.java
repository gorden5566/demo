package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car;

import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.ICar;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public abstract class AbsBMW implements ICar {
    private final static String BMW_BAND = "宝马汽车";

    @Override
    public String getBand() {
        return BMW_BAND;
    }

    /**
     * 型号由具体的实现类实现
     *
     * @return
     */
    @Override
    public abstract String getModel();
}
