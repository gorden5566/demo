package com.gorden5566.learn.pattern.factory.human;

public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄种人皮肤颜色为黄色！");
    }

    @Override
    public void talk() {
        System.out.println("黄种人说话！");
    }
}
