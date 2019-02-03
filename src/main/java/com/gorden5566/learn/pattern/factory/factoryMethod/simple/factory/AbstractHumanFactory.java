package com.gorden5566.learn.pattern.factory.factoryMethod.simple.factory;

import com.gorden5566.learn.pattern.factory.human.Human;

public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
