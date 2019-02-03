package com.gorden5566.learn.pattern.factory.abstractFactory.demo.factory;

import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.AbstractProductA;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.AbstractProductB;

public abstract class AbstractCreator {

    public abstract AbstractProductA createProductA();

    public abstract AbstractProductB createProductB();
}
