package com.gorden5566.learn.pattern.prototype.test.construct;

public class Client {
    public static void main(String[] args) {
        Thing thing = new Thing();

        // clone时构造函数不会执行
        Thing cloneThing = thing.clone();
    }
}
