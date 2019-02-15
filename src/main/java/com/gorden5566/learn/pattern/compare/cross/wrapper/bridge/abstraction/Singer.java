package com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.abstraction;

import com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.AbsAction;
import com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.AbsStar;
import com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.implementor.Sing;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Singer extends AbsStar {

    public Singer() {
        super(new Sing());
    }

    public Singer(AbsAction action) {
        super(action);
    }

    @Override
    public void doJob() {
        System.out.println("======歌星的工作=====");
        super.doJob();
    }
}
