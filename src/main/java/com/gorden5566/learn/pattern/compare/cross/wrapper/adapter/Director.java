package com.gorden5566.learn.pattern.compare.cross.wrapper.adapter;

import com.gorden5566.learn.pattern.compare.cross.wrapper.adapter.adapter.StandIn;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Director {
    public static void main(String[] args) {
        System.out.println("=======演戏过程模拟==========");
        //定义一个大明星
        IStar star = new FilmStar();
        star.act("前十五分钟，明星本人演戏");

        //导演把一个普通演员当做明星演员来用
        IActor actor = new UnknownActor();
        IStar standIn = new StandIn(actor);

        standIn.act("中间五分钟，替身在演戏");
        star.act("后十五分钟，明星本人演戏");
    }
}
