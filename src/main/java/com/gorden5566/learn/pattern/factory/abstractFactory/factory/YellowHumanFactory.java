package com.gorden5566.learn.pattern.factory.abstractFactory.factory;

import com.gorden5566.learn.pattern.factory.human.Human;
import com.gorden5566.learn.pattern.factory.human.YellowHuman;

public class YellowHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new YellowHuman();
    }
}
