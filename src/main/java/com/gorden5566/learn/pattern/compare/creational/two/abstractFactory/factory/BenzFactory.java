package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.factory;

import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.CarFactory;
import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.ICar;
import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car.BenzSuv;
import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car.BenzVan;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class BenzFactory implements CarFactory {
    @Override
    public ICar createSuv() {
        return new BenzSuv();
    }

    @Override
    public ICar createVan() {
        return new BenzVan();
    }
}
