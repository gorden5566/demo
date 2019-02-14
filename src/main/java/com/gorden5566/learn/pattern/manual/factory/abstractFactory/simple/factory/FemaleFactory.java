package com.gorden5566.learn.pattern.manual.factory.abstractFactory.simple.factory;

import com.gorden5566.learn.pattern.manual.factory.common.extend.Human;
import com.gorden5566.learn.pattern.manual.factory.common.extend.impl.FemaleBlackHuman;
import com.gorden5566.learn.pattern.manual.factory.common.extend.impl.FemaleWhiteHuman;
import com.gorden5566.learn.pattern.manual.factory.common.extend.impl.FemaleYellowHuman;

public class FemaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
}
