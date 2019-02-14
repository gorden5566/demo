package com.gorden5566.learn.pattern.manual.factory.common.extend;

public abstract class AbstractYellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄种人皮肤颜色为黄色！");
    }

    @Override
    public void talk() {
        System.out.println("黄种人说话！");
    }
}
