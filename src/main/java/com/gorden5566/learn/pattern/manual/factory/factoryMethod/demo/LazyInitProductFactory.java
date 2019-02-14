package com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo;

import com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo.product.ConcreteProduct1;
import com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo.product.ConcreteProduct2;
import com.gorden5566.learn.pattern.manual.factory.factoryMethod.demo.product.Product;

import java.util.HashMap;
import java.util.Map;

public class LazyInitProductFactory {
    private static final Map<String, Product> productMap = new HashMap<>();

    public static synchronized Product createProduct(String type) {
        Product product = null;

        // 从缓存中获取实例
        if (productMap.containsKey(type)) {
            product = productMap.get(type);
        } else {
            if (type.equals("Product1")) {
                product = new ConcreteProduct1();
            } else {
                product = new ConcreteProduct2();
            }
            productMap.put(type, product);
        }

        return product;
    }
}
