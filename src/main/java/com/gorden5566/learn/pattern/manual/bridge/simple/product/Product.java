package com.gorden5566.learn.pattern.manual.bridge.simple.product;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public abstract class Product {
    /**
     * 甭管是什么产品它总要能被生产出来
     */
    public abstract void beProducted();

    /**
     * 生产出来的东西，一定要销售出去，否则亏本
     */
    public abstract void beSelled();
}
