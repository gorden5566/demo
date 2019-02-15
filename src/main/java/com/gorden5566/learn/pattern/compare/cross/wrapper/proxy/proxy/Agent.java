package com.gorden5566.learn.pattern.compare.cross.wrapper.proxy.proxy;

import com.gorden5566.learn.pattern.compare.cross.wrapper.proxy.IStar;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Agent implements IStar {

    private IStar star;

    public Agent(IStar star) {
        this.star = star;
    }

    @Override
    public void sign() {
        star.sign();
    }
}
