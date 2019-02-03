package com.gorden5566.learn.pattern.factory.abstractFactory.demo;

import com.gorden5566.learn.pattern.factory.abstractFactory.demo.factory.AbstractCreator;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.factory.Creator1;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.factory.Creator2;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.AbstractProductA;
import com.gorden5566.learn.pattern.factory.abstractFactory.demo.product.AbstractProductB;

public class Client {
    public static void main(String[] args) {
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();

        // 生产一套
        AbstractProductA a1 = creator1.createProductA();
        AbstractProductB b1 = creator1.createProductB();

        // 功能升级，生产另一套
        AbstractProductA a2 = creator2.createProductA();
        AbstractProductB b2 = creator2.createProductB();

    }
}
