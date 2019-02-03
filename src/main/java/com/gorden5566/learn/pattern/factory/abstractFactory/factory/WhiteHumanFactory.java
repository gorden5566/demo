package com.gorden5566.learn.pattern.factory.abstractFactory.factory;

import com.gorden5566.learn.pattern.factory.abstractFactory.factory.AbstractHumanFactory;
import com.gorden5566.learn.pattern.factory.human.Human;
import com.gorden5566.learn.pattern.factory.human.WhiteHuman;

public class WhiteHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new WhiteHuman();
    }
}
