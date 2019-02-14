package com.gorden5566.learn.pattern.manual.visitor.dispatch;

import com.gorden5566.learn.pattern.manual.visitor.dispatch.actor.AbstractActor;
import com.gorden5566.learn.pattern.manual.visitor.dispatch.actor.OldActor;
import com.gorden5566.learn.pattern.manual.visitor.dispatch.role.KungFuRole;
import com.gorden5566.learn.pattern.manual.visitor.dispatch.role.Role;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Client {
    public static void main(String[] args) {
        //定义一个演员，用于访问角色
        AbstractActor actor = new OldActor();

        //定义一个角色
        Role role = new KungFuRole();

        // 说实话，这里讲的不好，没有说清楚这样做到底是在搞啥
        role.accept(actor);
    }
}
