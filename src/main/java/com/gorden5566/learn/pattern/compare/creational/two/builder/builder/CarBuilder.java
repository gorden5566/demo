package com.gorden5566.learn.pattern.compare.creational.two.builder.builder;

import com.gorden5566.learn.pattern.compare.creational.two.builder.director.Blueprint;
import com.gorden5566.learn.pattern.compare.creational.two.builder.Car;
import com.gorden5566.learn.pattern.compare.creational.two.builder.ICar;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public abstract class CarBuilder {
    /**
     * 待建造的汽车
     */
    private ICar car;

    /**
     * 设计蓝图
     */
    private Blueprint bp;

    public Car buildCar() {
        //按照顺序生产一辆车
        return new Car(buildEngine(), buildWheel());
    }

    /**
     * 接收一份设计蓝图
     *
     * @param blueprint
     */
    public void receiveBlueprint(Blueprint blueprint) {
        this.bp = blueprint;
    }

    /**
     * 查看蓝图，只有真正的建造者才可以查看蓝图
     *
     * @return
     */
    protected Blueprint getBlueprint() {
        return bp;
    }

    /**
     * 建造车轮
     *
     * @return
     */
    protected abstract String buildWheel();

    /**
     * 建造引擎
     *
     * @return
     */
    protected abstract String buildEngine();

}
