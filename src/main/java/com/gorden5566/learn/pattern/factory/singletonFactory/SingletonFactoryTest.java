package com.gorden5566.learn.pattern.factory.singletonFactory;

public class SingletonFactoryTest {
    public static void main(String[] args) {
        Singleton singleton = SingletonFactory.getSingleton();
        singleton.doSomething();
    }
}
