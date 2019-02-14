package com.gorden5566.learn.pattern.manual.factory.factoryMethod.multiple.factory;

import com.gorden5566.learn.pattern.manual.factory.common.base.Human;
import com.gorden5566.learn.pattern.manual.factory.common.base.WhiteHuman;

public class WhiteHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new WhiteHuman();
    }
}
