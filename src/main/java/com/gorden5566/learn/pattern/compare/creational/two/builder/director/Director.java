package com.gorden5566.learn.pattern.compare.creational.two.builder.director;

import com.gorden5566.learn.pattern.compare.creational.two.builder.ICar;
import com.gorden5566.learn.pattern.compare.creational.two.builder.builder.BMWBuilder;
import com.gorden5566.learn.pattern.compare.creational.two.builder.builder.BenzBuilder;
import com.gorden5566.learn.pattern.compare.creational.two.builder.builder.CarBuilder;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Director {
    /**
     * 声明对建造者的引用
     */
    private CarBuilder benzBuilder = new BenzBuilder();
    private CarBuilder bmwBuilder = new BMWBuilder();

    /**
     * 生产奔驰SUV
     *
     * @return
     */
    public ICar createBenzSuv() {
        //制造出汽车
        return createCar(benzBuilder, "benz的引擎", "benz的轮胎");
    }

    /**
     * 生产出一辆宝马商务车
     *
     * @return
     */
    public ICar createBMWVan() {
        return createCar(benzBuilder, "BMW的引擎", "BMW的轮胎");
    }

    /**
     * 生产出一个混合车型
     *
     * @return
     */
    public ICar createComplexCar() {
        return createCar(bmwBuilder, "BMW的引擎", "benz的轮胎");
    }

    /**
     * 生产车辆
     *
     * @param carBuilder
     * @param engine
     * @param wheel
     * @return
     */
    private ICar createCar(CarBuilder carBuilder, String engine, String wheel) {
        //导演怀揣蓝图
        Blueprint bp = new Blueprint();
        bp.setEngine(engine);
        bp.setWheel(wheel);

        System.out.println("获得生产蓝图");
        carBuilder.receiveBlueprint(bp);

        return carBuilder.buildCar();
    }
}
