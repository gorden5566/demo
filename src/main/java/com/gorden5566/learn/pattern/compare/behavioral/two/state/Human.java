package com.gorden5566.learn.pattern.compare.behavioral.two.state;

import com.gorden5566.learn.pattern.compare.behavioral.two.state.state.AdultState;
import com.gorden5566.learn.pattern.compare.behavioral.two.state.state.ChildState;
import com.gorden5566.learn.pattern.compare.behavioral.two.state.state.OldState;

/**
 * 环境角色
 * 具有登记状态变化的功能，与具体的状态类协作，共同完成状态切换行为随之切换的任务
 *
 * @author gorden5566
 * @date 2019-02-14
 */
public class Human {
    public static final HumanState CHILD_STATE = new ChildState();
    public static final HumanState ADULT_STATE = new AdultState();
    public static final HumanState OLD_STATE = new OldState();

    private HumanState humanState;

    public void setHumanState(HumanState humanState) {
        this.humanState = humanState;
        this.humanState.setHuman(this);
    }

    public void work() {
        this.humanState.work();
    }
}
