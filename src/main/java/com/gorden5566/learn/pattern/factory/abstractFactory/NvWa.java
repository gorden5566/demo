package com.gorden5566.learn.pattern.factory.abstractFactory;

import com.gorden5566.learn.pattern.factory.abstractFactory.factory.BlackHumanFactory;
import com.gorden5566.learn.pattern.factory.abstractFactory.factory.WhiteHumanFactory;
import com.gorden5566.learn.pattern.factory.abstractFactory.factory.YellowHumanFactory;
import com.gorden5566.learn.pattern.factory.human.Human;

public class NvWa {
    public static void main(String[] args) {
        System.out.println("------造出的第一批人种-------");
        Human whiteHuman = (new WhiteHumanFactory()).createHuman();
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("");
        System.out.println("------造出的第二批人种-------");
        Human blackHuman = (new BlackHumanFactory()).createHuman();
        blackHuman.getColor();
        blackHuman.talk();

        System.out.println("");
        System.out.println("------造出的第三批人种-------");
        Human yellowHuman = (new YellowHumanFactory()).createHuman();
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
