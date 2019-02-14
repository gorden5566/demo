package com.gorden5566.learn.pattern.compare.creational.one.factoryMethod;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Client {
    public static void main(String[] args) {
        //生产一个成年超人
        ISuperMan adultSuperMan = SuperManFactory.createSuperMan("adult");
        //展示一下超人的技能
        adultSuperMan.specialTalent();
    }
}
