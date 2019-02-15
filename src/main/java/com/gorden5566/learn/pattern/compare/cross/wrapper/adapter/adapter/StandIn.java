package com.gorden5566.learn.pattern.compare.cross.wrapper.adapter.adapter;

import com.gorden5566.learn.pattern.compare.cross.wrapper.adapter.IActor;
import com.gorden5566.learn.pattern.compare.cross.wrapper.adapter.IStar;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class StandIn implements IStar {

    private IActor actor;

    public StandIn(IActor actor) {
        this.actor = actor;
    }

    @Override
    public void act(String context) {
        this.actor.playact(context);
    }
}
