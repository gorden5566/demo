package com.gorden5566.learn.pattern.manual.visitor.demo;

import com.gorden5566.learn.pattern.manual.visitor.demo.element.ConcreteElement1;
import com.gorden5566.learn.pattern.manual.visitor.demo.element.ConcreteElement2;
import com.gorden5566.learn.pattern.manual.visitor.demo.element.Element;

import java.util.Random;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class ObjectStructure {
    /**
     * 对象生成器，这里通过一个工厂方法模式模拟
     *
     * @return
     */
    public static Element createElement(){
        Random rand = new Random();
        if(rand.nextInt(100) > 50){
            return new ConcreteElement1();
        }else{
            return new ConcreteElement2();
        }
    }
}
