package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.factory;

import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.CarFactory;
import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.ICar;
import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car.BMWSuv;
import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.car.BMWVan;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class BMWFactory implements CarFactory {
    @Override
    public ICar createSuv() {
        return new BMWSuv();
    }

    @Override
    public ICar createVan() {
        return new BMWVan();
    }
}
