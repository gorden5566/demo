package com.gorden5566.learn.pattern.compare.cross.wrapper.proxy;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Singer implements IStar {
    @Override
    public void sign() {
        System.out.println("明星签字：我是XXX大明星");
    }
}
