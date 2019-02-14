package com.gorden5566.learn.pattern.compare.structural.two.decorator.decorator;

import com.gorden5566.learn.pattern.compare.structural.two.Swan;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class BeautifyAppearance extends Decorator {
    public BeautifyAppearance(Swan swan) {
        super(swan);
    }

    @Override
    public void desAppearance() {
        System.out.println("外表是纯白色的，非常惹人喜爱！");
    }
}
