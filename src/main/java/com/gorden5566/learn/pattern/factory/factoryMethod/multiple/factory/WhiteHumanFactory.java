package com.gorden5566.learn.pattern.factory.factoryMethod.multiple.factory;

import com.gorden5566.learn.pattern.factory.human.Human;
import com.gorden5566.learn.pattern.factory.human.WhiteHuman;

public class WhiteHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new WhiteHuman();
    }
}
