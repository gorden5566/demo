package com.gorden5566.learn.pattern.manual.factory.simpleFactory;

import com.gorden5566.learn.pattern.manual.factory.common.base.BlackHuman;
import com.gorden5566.learn.pattern.manual.factory.common.base.Human;
import com.gorden5566.learn.pattern.manual.factory.common.base.WhiteHuman;
import com.gorden5566.learn.pattern.manual.factory.simpleFactory.factory.HumanFactory;

public class NuWa {
    public static void main(String[] args) {
        System.out.println("------造出的第一批人种-------");
        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("");
        System.out.println("------造出的第二批人种-------");
        Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

        System.out.println("");
        System.out.println("------造出的第三批人种-------");
        Human yellowHuman = HumanFactory.createHuman(BlackHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
