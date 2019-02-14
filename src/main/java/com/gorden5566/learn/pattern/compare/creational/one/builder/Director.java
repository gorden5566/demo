package com.gorden5566.learn.pattern.compare.creational.one.builder;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Director {
    /**
     * 两个建造者的应用
     */
    private static Builder adultBuilder = new AdultSuperManBuilder();

    /**
     * 未成年超人的建造者
     */
    private static Builder childBuilder = new ChildSuperManBuilder();

    /**
     * 建造一个成年、会飞行的超人
     *
     * @return
     */
    public static SuperMan getAdultSuperMan() {
        return adultBuilder.getSuperMan();
    }

    /**
     * 建造一个未成年、刀枪不入的超人
     *
     * @return
     */
    public static SuperMan getChildSuperMan() {
        return childBuilder.getSuperMan();
    }
}
