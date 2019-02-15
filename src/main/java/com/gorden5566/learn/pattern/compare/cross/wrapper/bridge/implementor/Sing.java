package com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.implementor;

import com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.AbsAction;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Sing extends AbsAction {
    @Override
    public void desc() {
        System.out.println("唱出优美的歌曲");
    }
}
