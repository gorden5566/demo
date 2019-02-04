package com.gorden5566.learn.pattern.prototype.test.shallow;

public class Client {
    public static void main(String[] args) {
        Thing thing = new Thing();
        thing.setValue("张三");
        System.out.println(thing.getArrayList());

        Thing cloneThing = thing.clone();
        cloneThing.setValue("李四");

        System.out.println(thing.getArrayList());
    }
}
