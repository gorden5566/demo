package com.gorden5566.learn.pattern.bridge.simple.product;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class IPod extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出的iPod是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的iPod卖出去了...");
    }
}
