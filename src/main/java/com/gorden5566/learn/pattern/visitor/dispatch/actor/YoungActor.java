package com.gorden5566.learn.pattern.visitor.dispatch.actor;

import com.gorden5566.learn.pattern.visitor.dispatch.role.KungFuRole;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class YoungActor extends AbstractActor {
    @Override
    public void act(KungFuRole role) {
        System.out.println("最喜欢演功夫角色");
    }
}
