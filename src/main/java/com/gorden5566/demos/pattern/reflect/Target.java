package com.gorden5566.demos.pattern.reflect;

public class Target implements ITarget {
    @Override
    public void doSomeThing() {
        System.out.println("doSomeThing");
    }

    @Override
    public void doOtherThing() {
        System.out.println("doOtherThing");
    }
}
