package com.gorden5566.learn.pattern.manual.visitor.dispatch.role;

import com.gorden5566.learn.pattern.manual.visitor.dispatch.actor.AbstractActor;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public interface Role {
    /**
     * 演员要扮演的角色
     *
     * @param actor
     */
    void accept(AbstractActor actor);
}
