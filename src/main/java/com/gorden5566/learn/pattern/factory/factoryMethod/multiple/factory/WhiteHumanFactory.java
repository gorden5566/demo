package com.gorden5566.learn.pattern.factory.factoryMethod.multiple.factory;

import com.gorden5566.learn.pattern.factory.common.base.Human;
import com.gorden5566.learn.pattern.factory.common.base.WhiteHuman;

public class WhiteHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new WhiteHuman();
    }
}
