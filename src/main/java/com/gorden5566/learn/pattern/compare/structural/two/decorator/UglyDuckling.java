package com.gorden5566.learn.pattern.compare.structural.two.decorator;

import com.gorden5566.learn.pattern.compare.structural.two.Swan;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class UglyDuckling implements Swan {
    @Override
    public void fly() {
        System.out.println("叫声是克噜——克噜——克噜");
    }

    @Override
    public void cry() {
        System.out.println("不能飞行");
    }

    @Override
    public void desAppearance() {
        System.out.println("外形是脏兮兮的白色，毛茸茸的大脑袋");
    }
}
