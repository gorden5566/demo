package com.gorden5566.learn.pattern.manual.builder.demo;

public abstract class Builder {

    /**
     * 设置产品零件
     */
    public abstract void setPart();

    /**
     * 组建一个产品
     *
     * @return
     */
    public abstract Product buildProduct();
}
