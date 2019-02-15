package com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.implementor;

import com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.AbsAction;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class ActFilm extends AbsAction {
    @Override
    public void desc() {
        System.out.println("演出精彩绝伦的电影");
    }
}
