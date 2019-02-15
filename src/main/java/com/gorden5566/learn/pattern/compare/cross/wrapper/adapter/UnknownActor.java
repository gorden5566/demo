package com.gorden5566.learn.pattern.compare.cross.wrapper.adapter;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class UnknownActor implements IActor {
    @Override
    public void playact(String context) {
        System.out.println("普通演员："+context);
    }
}
