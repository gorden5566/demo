package com.gorden5566.learn.pattern.compare.cross.wrapper.decorator.decorator;

import com.gorden5566.learn.pattern.compare.cross.wrapper.decorator.Decorator;
import com.gorden5566.learn.pattern.compare.cross.wrapper.decorator.IStar;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class HotAir extends Decorator {
    public HotAir(IStar star) {
        super(star);
    }

    @Override
    public void act() {
        System.out.println("演前：夸夸其谈，没有自己不能演的角色");
        super.act();
    }
}
