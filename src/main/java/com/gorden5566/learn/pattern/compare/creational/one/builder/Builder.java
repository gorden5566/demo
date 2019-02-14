package com.gorden5566.learn.pattern.compare.creational.one.builder;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public abstract class Builder {
    /**
     * 定义一个超人的应用
     */
    protected final SuperMan superMan = new SuperMan();

    /**
     * 构建出超人的躯体
     *
     * @param body
     */
    public void setBody(String body) {
        this.superMan.setBody(body);
    }

    /**
     * 构建出超人的特殊技能
     *
     * @param st
     */
    public void setSpecialTalent(String st) {
        this.superMan.setSpecialTalent(st);
    }

    /**
     * 构建出超人的特殊标记
     *
     * @param ss
     */
    public void setSpecialSymbol(String ss) {
        this.superMan.setSpecialSymbol(ss);
    }

    /**
     * 构建出一个完整的超人
     *
     * @return
     */
    public abstract SuperMan getSuperMan();

}
