package com.gorden5566.learn.pattern.compare.creational.two.builder.builder;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class BenzBuilder extends CarBuilder {
    @Override
    protected String buildWheel() {
        return super.getBlueprint().getEngine();
    }

    @Override
    protected String buildEngine() {
        return super.getBlueprint().getEngine();
    }
}
