package com.gorden5566.learn.pattern.manual.prototype.test.construct;

public class Thing implements Cloneable {

    public Thing() {
        System.out.println("构造函数");
    }

    @Override
    protected Thing clone() {
        Thing thing = null;
        try {
            thing = (Thing) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return thing;
    }
}
