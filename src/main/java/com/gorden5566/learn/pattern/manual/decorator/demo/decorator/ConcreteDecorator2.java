package com.gorden5566.learn.pattern.manual.decorator.demo.decorator;

import com.gorden5566.learn.pattern.manual.decorator.demo.component.Component;

public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    private void method1() {
        System.out.println("method2 修饰");
    }

    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
