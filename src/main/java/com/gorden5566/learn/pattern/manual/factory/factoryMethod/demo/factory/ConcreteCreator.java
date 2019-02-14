package com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo.factory;

import com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo.product.Product;

public class ConcreteCreator extends Creator {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
