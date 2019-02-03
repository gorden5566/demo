package com.gorden5566.learn.pattern.factory.abstractFactory.simple.factory;

import com.gorden5566.learn.pattern.factory.common.extend.Human;

public interface HumanFactory {

    Human createYellowHuman();

    Human createWhiteHuman();

    Human createBlackHuman();
}
