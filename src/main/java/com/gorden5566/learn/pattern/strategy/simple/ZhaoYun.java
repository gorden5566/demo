package com.gorden5566.learn.pattern.strategy.simple;

import com.gorden5566.learn.pattern.strategy.simple.strategy.BackDoor;
import com.gorden5566.learn.pattern.strategy.simple.strategy.BlockEnemy;
import com.gorden5566.learn.pattern.strategy.simple.strategy.GivenGreenLight;

public class ZhaoYun {
    public static void main(String[] args) {
        Context context;
        //刚刚到吴国的时候拆第一个
        System.out.println("---刚刚到吴国的时候拆第一个---");

        context = new Context(new BackDoor());
        context.operate();

        System.out.println();
        //刘备乐不思蜀了， 拆第二个了
        System.out.println("---刘备乐不思蜀了， 拆第二个了---");
        context = new Context(new GivenGreenLight());
        context.operate();

        System.out.println();
        //孙权的小兵追来了， 咋办？ 拆第三个
        System.out.println("---孙权的小兵追来了， 咋办？ 拆第三个---");
        context = new Context(new BlockEnemy());
        context.operate();
    }
}
