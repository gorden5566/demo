package com.gorden5566.learn.pattern.manual.visitor.dispatch.role;

import com.gorden5566.learn.pattern.manual.visitor.dispatch.actor.AbstractActor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class IdiotRole implements Role {
    @Override
    public void accept(AbstractActor actor) {
        actor.act(this);
    }
}
