package com.gorden5566.learn.pattern.manual.facade.demo;

public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
