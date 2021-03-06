package com.gorden5566.learn.pattern.compare.creational.one.builder;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class AdultSuperManBuilder extends Builder {
    @Override
    public SuperMan getSuperMan() {
        super.setBody("强壮的躯体");
        super.setSpecialTalent("会飞行");
        super.setSpecialSymbol("胸前带S标记");
        return super.superMan;
    }
}
