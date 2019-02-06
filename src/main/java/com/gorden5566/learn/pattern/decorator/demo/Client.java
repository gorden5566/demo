package com.gorden5566.learn.pattern.decorator.demo;

import com.gorden5566.learn.pattern.decorator.demo.component.Component;
import com.gorden5566.learn.pattern.decorator.demo.component.ConcreteComponent;
import com.gorden5566.learn.pattern.decorator.demo.decorator.ConcreteDecorator1;
import com.gorden5566.learn.pattern.decorator.demo.decorator.ConcreteDecorator2;

public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecorator1(component);
        component = new ConcreteDecorator2(component);
        component.operate();
    }
}
