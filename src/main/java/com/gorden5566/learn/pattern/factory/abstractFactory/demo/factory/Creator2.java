package com.gorden5566.learn.pattern.factory.abstractFactory.demo.factory;

import com.gorden5566.learn.pattern.factory.abstractFactory.demo.factory.AbstractCreator;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.AbstractProductA;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.AbstractProductB;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.ProductA2;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.ProductB2;

public class Creator2 extends AbstractCreator {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
