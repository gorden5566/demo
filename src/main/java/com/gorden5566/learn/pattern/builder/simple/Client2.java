package com.gorden5566.learn.pattern.builder.simple;

public class Client2 {
    public static void main(String[] args) {
        Director director = new Director();
        //1辆A类型的奔驰车
        for (int i = 0; i < 1; i++) {
            director.getABenzModel().run();
        }

        //100辆B类型的奔驰车
        for (int i = 0; i < 100; i++) {
            director.getBBenzModel().run();
        }

        //1000辆C类型的宝马车
        for (int i = 0; i < 1000; i++) {
            director.getCBMWModel().run();
        }
    }
}
