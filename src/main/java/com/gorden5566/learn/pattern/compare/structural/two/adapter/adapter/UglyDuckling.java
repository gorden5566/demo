package com.gorden5566.learn.pattern.compare.structural.two.adapter.adapter;

import com.gorden5566.learn.pattern.compare.structural.two.adapter.Duck;
import com.gorden5566.learn.pattern.compare.structural.two.adapter.WhiteSwan;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class UglyDuckling extends WhiteSwan implements Duck {

    @Override
    public void cry() {
        super.cry();
    }

    @Override
    public void desAppearance() {
        super.desAppearance();
    }

    @Override
    public void desBehavior() {
        System.out.println("会游泳");
        //还会飞行
        super.fly();
    }
}
