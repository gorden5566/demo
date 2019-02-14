package com.gorden5566.learn.pattern.manual.factory.common.extend;

public abstract class AbstractBlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色的!");
    }

    @Override
    public void talk() {
        System.out.println("黑人说话！");
    }
}
