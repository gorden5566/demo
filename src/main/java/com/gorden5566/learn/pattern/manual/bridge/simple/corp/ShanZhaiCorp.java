package com.gorden5566.learn.pattern.manual.bridge.simple.corp;

import com.gorden5566.learn.pattern.manual.bridge.simple.product.Product;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class ShanZhaiCorp extends Corp {
    /**
     * 构造函数，由子类定义传递具体的产品进来
     *
     * @param product
     */
    public ShanZhaiCorp(Product product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱呀...");
    }
}
