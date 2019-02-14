package com.gorden5566.learn.pattern.compare.behavioral.two.state;

/**
 * 状态
 *
 * @author gorden5566
 * @date 2019-02-14
 */
public abstract class HumanState {

    protected Human human;

    public void setHuman(Human human) {
        this.human = human;
    }

    /**
     * 不管人是什么状态都要工作
     */
    public abstract void work();
}
