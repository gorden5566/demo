package com.gorden5566.learn.pattern.compare.cross.wrapper.decorator;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public abstract class Decorator implements IStar {

    private IStar star;

    public Decorator(IStar star) {
        this.star = star;
    }

    @Override
    public void act() {
        this.star.act();
    }
}
