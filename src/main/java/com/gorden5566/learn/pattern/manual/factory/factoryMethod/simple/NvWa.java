package com.gorden5566.learn.pattern.manual.factory.factoryMethod.simple;

import com.gorden5566.learn.pattern.manual.factory.factoryMethod.simple.factory.AbstractHumanFactory;
import com.gorden5566.learn.pattern.manual.factory.factoryMethod.simple.factory.HumanFactory;
import com.gorden5566.learn.pattern.manual.factory.common.base.BlackHuman;
import com.gorden5566.learn.pattern.manual.factory.common.base.Human;
import com.gorden5566.learn.pattern.manual.factory.common.base.WhiteHuman;

public class NvWa {
    public static void main(String[] args) {
        AbstractHumanFactory yingyangLu = new HumanFactory();

        System.out.println("------造出的第一批人种-------");
        Human whiteHuman = yingyangLu.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("");
        System.out.println("------造出的第二批人种-------");
        Human blackHuman = yingyangLu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

        System.out.println("");
        System.out.println("------造出的第三批人种-------");
        Human yellowHuman = yingyangLu.createHuman(BlackHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
