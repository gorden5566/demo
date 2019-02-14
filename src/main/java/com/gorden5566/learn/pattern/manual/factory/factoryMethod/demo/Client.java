package com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo;

import com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo.factory.ConcreteCreator;
import com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo.factory.Creator;
import com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo.product.ConcreteProduct1;
import com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo.product.Product;

public class Client {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();

        Product product = creator.createProduct(ConcreteProduct1.class);

        // 其他业务逻辑
    }
}
