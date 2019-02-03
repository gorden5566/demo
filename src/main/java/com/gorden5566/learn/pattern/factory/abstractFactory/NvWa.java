package com.gorden5566.learn.pattern.factory.abstractFactory;

import com.gorden5566.learn.pattern.factory.abstractFactory.factory.FemaleFactory;
import com.gorden5566.learn.pattern.factory.abstractFactory.factory.HumanFactory;
import com.gorden5566.learn.pattern.factory.abstractFactory.factory.MaleFactory;
import com.gorden5566.learn.pattern.factory.common.extend.Human;

public class NvWa {
    public static void main(String[] args) {
        HumanFactory maleFactory = new MaleFactory();
        HumanFactory femaleFactory = new FemaleFactory();

        System.out.println("-----生产第一个黄人男性-----");
        Human maleYellowHuman = maleFactory.createYellowHuman();
        maleYellowHuman.getColor();
        maleYellowHuman.talk();
        maleYellowHuman.getSex();

        System.out.println("-----生产第一个黄人女性-----");
        Human femaleYellowHuman = femaleFactory.createYellowHuman();
        femaleYellowHuman.getColor();
        femaleYellowHuman.talk();
        femaleYellowHuman.getSex();
    }
}
