package com.gorden5566.learn.pattern.bridge.simple.product;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class House extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的房子是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的房子卖出去了...");
    }
}
