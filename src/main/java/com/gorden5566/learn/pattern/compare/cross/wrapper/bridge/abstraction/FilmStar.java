package com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.abstraction;

import com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.AbsAction;
import com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.AbsStar;
import com.gorden5566.learn.pattern.compare.cross.wrapper.bridge.implementor.ActFilm;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class FilmStar extends AbsStar {

    public FilmStar() {
        super(new ActFilm());
    }

    public FilmStar(AbsAction action) {
        super(action);
    }

    @Override
    public void doJob() {
        System.out.println("======影星的工作=====");
        super.doJob();
    }
}
