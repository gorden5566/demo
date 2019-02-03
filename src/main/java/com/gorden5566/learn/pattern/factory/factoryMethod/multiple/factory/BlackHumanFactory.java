package com.gorden5566.learn.pattern.factory.factoryMethod.multiple.factory;

import com.gorden5566.learn.pattern.factory.common.base.BlackHuman;
import com.gorden5566.learn.pattern.factory.common.base.Human;

public class BlackHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new BlackHuman();
    }
}
