package com.gorden5566.learn.pattern.factory.abstractFactory.factory;

import com.gorden5566.learn.pattern.factory.common.extend.Human;
import com.gorden5566.learn.pattern.factory.common.extend.impl.MaleBlackHuman;
import com.gorden5566.learn.pattern.factory.common.extend.impl.MaleWhiteHuman;
import com.gorden5566.learn.pattern.factory.common.extend.impl.MaleYellowHuman;

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
