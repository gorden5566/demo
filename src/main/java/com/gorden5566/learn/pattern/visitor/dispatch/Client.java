package com.gorden5566.learn.pattern.visitor.dispatch;

import com.gorden5566.learn.pattern.visitor.dispatch.actor.AbstractActor;
import com.gorden5566.learn.pattern.visitor.dispatch.actor.OldActor;
import com.gorden5566.learn.pattern.visitor.dispatch.role.KungFuRole;
import com.gorden5566.learn.pattern.visitor.dispatch.role.Role;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Client {
    public static void main(String[] args) {
        //定义一个演员
        AbstractActor actor = new OldActor();

        //定义一个角色，问题点：通过父类型访问
        Role role = new KungFuRole();

        //开始演戏：演员可以扮演任何角色
        actor.act(role);

        //开始演戏：年龄大了，不能演功夫角色
        actor.act(new KungFuRole());
    }
}
