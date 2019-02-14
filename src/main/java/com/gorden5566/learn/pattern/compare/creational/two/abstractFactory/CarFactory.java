package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory;

import com.gorden5566.learn.pattern.compare.creational.two.abstractFactory.ICar;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public interface CarFactory {
    /**
     * 生产SUV
     *
     * @return
     */
    ICar createSuv();

    /**
     * 生产商务车
     *
     * @return
     */
    ICar createVan();

}
