package com.gorden5566.learn.pattern.bridge.demo;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class Client {
    public static void main(String[] args) {
        //定义一个实现化角色
        Implementor imp = new ConcreteImplementor1();
        //定义一个抽象化角色
        Abstraction abs = new RefinedAbstraction(imp);
        //执行
        abs.request();
    }
}
