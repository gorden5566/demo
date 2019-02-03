package com.gorden5566.learn.pattern.factory.factoryMethod.multiple.factory;

import com.gorden5566.learn.pattern.factory.human.BlackHuman;
import com.gorden5566.learn.pattern.factory.human.Human;

public class BlackHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new BlackHuman();
    }
}
