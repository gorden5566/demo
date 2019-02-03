package com.gorden5566.learn.pattern.factory.common.base;

public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白种人皮肤颜色为白色！");
    }

    @Override
    public void talk() {
        System.out.println("白种人说话！");
    }
}
