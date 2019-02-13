package com.gorden5566.learn.pattern.flyweight.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class FlyweightFactory {

    /**
     * 定义一个池
     */
    public static Map<String, Flyweight> pool = new HashMap<>();

    /**
     * 享元工厂
     *
     * @param Extrinsic
     * @return
     */
    public static Flyweight getFlyweight(String Extrinsic) {
        //需要返回的对象
        Flyweight flyweight = null;
        //在池中没有该对象
        if (pool.containsKey(Extrinsic)) {
            flyweight = pool.get(Extrinsic);
        } else {
            //根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight1(Extrinsic);
            //放置到池中
            pool.put(Extrinsic, flyweight);
        }
        return flyweight;
    }
}
