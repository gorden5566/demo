package com.gorden5566.learn.pattern.manual.factory.abstractFactory.simple.factory;

import com.gorden5566.learn.pattern.manual.factory.common.extend.Human;

public interface HumanFactory {

    Human createYellowHuman();

    Human createWhiteHuman();

    Human createBlackHuman();
}
