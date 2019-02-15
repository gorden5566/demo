package com.gorden5566.learn.pattern.compare.cross.wrapper.adapter;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class FilmStar implements IStar {
    @Override
    public void act(String context) {
        System.out.println("明星演戏：" + context);
    }
}
