package com.gorden5566.learn.pattern.visitor.dispatch.actor;

import com.gorden5566.learn.pattern.visitor.dispatch.role.KungFuRole;
import com.gorden5566.learn.pattern.visitor.dispatch.role.Role;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public abstract class AbstractActor {
    /**
     * 演员都能够演一个角色
     *
     * @param role
     */
    public void act(Role role){
        System.out.println("演员可以扮演任何角色");
    }

    /**
     * 可以演功夫戏
     *
     * @param role
     */
    public void act(KungFuRole role){
        System.out.println("演员都可以演功夫角色");
    }
}
