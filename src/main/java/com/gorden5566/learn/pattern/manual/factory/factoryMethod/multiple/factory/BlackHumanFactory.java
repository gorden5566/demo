package com.gorden5566.learn.pattern.manual.factory.factoryMethod.multiple.factory;

import com.gorden5566.learn.pattern.manual.factory.common.base.BlackHuman;
import com.gorden5566.learn.pattern.manual.factory.common.base.Human;

public class BlackHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new BlackHuman();
    }
}
