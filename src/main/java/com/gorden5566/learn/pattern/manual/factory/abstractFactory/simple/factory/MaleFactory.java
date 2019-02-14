package com.gorden5566.learn.pattern.manual.factory.abstractFactory.simple.factory;

import com.gorden5566.learn.pattern.manual.factory.common.extend.Human;
import com.gorden5566.learn.pattern.manual.factory.common.extend.impl.MaleBlackHuman;
import com.gorden5566.learn.pattern.manual.factory.common.extend.impl.MaleWhiteHuman;
import com.gorden5566.learn.pattern.manual.factory.common.extend.impl.MaleYellowHuman;

public class MaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
}
