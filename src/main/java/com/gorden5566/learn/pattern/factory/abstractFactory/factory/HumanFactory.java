package com.gorden5566.learn.pattern.factory.abstractFactory.factory;

import com.gorden5566.learn.pattern.factory.common.extend.Human;

public interface HumanFactory {

    Human createYellowHuman();

    Human createWhiteHuman();

    Human createBlackHuman();
}
