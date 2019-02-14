package com.gorden5566.learn.pattern.manual.prototype.test.deep;

public class Client {
    public static void main(String[] args) {
        Thing thing = new Thing();
        thing.setValue("张三");
        System.out.println(thing.getArrayList());

        Thing cloneThing = thing.clone();
        cloneThing.setValue("李四");

        // 原对象引用属性不变
        System.out.println(thing.getArrayList());
    }
}
