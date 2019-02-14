package com.gorden5566.learn.pattern.compare.creational.one.builder;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Client {
    public static void main(String[] args) {
        //建造一个成年超人
        SuperMan adultSuperMan = Director.getAdultSuperMan();
        //展示一下超人的信息
        adultSuperMan.getSpecialTalent();
    }
}
