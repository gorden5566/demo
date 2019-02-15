package com.gorden5566.learn.pattern.compare.cross.wrapper.bridge;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class AbsStar {
    protected AbsAction action;

    public AbsStar(AbsAction action) {
        this.action = action;
    }

    /**
     * 每个明星都有自己的主要工作
     */
    public void doJob(){
        action.desc();
    }
}
