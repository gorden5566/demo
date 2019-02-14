package com.gorden5566.learn.pattern.manual.flyweight.demo;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class ConcreteFlyweight2 extends Flyweight {
    public ConcreteFlyweight2(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate() {
        System.out.println("ConcreteFlyweight2 operate");
    }
}
