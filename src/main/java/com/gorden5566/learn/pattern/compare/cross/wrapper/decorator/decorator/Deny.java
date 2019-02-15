package com.gorden5566.learn.pattern.compare.cross.wrapper.decorator.decorator;

import com.gorden5566.learn.pattern.compare.cross.wrapper.decorator.Decorator;
import com.gorden5566.learn.pattern.compare.cross.wrapper.decorator.IStar;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Deny extends Decorator {
    public Deny(IStar star) {
        super(star);
    }

    @Override
    public void act() {
        super.act();
        System.out.println("演后：百般抵赖，死不承认");
    }
}
