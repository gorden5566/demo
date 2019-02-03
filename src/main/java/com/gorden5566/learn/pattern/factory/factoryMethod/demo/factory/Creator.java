package com.gorden5566.learn.pattern.factory.factoryMethod.demo.factory;

import com.gorden5566.learn.pattern.factory.factoryMethod.demo.product.Product;

public abstract class Creator {
    public abstract <T extends Product> T createProduct(Class<T> c);
}
