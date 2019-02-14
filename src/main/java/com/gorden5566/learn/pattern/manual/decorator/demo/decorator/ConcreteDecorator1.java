package com.gorden5566.learn.pattern.manual.decorator.demo.decorator;

import com.gorden5566.learn.pattern.manual.decorator.demo.component.Component;

public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    private void method1() {
        System.out.println("method1 修饰");
    }

    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
