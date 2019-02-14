package com.gorden5566.learn.pattern.compare.creational.two.abstractFactory;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public interface ICar {
    /**
     * 汽车的生产商，也就是牌子
     * @return
     */
    String getBand();

    /**
     * 汽车的型号
     *
     * @return
     */
    String getModel();
}
