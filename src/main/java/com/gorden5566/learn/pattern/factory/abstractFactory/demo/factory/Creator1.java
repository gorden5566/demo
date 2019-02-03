package com.gorden5566.learn.pattern.factory.abstractFactory.demo.factory;

import com.gorden5566.learn.pattern.factory.abstractFactory.demo.factory.AbstractCreator;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.AbstractProductA;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.AbstractProductB;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.ProductA1;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.ProductB1;

public class Creator1 extends AbstractCreator {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
