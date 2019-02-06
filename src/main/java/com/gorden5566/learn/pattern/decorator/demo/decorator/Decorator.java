package com.gorden5566.learn.pattern.decorator.demo.decorator;

import com.gorden5566.learn.pattern.decorator.demo.component.Component;

public class Decorator extends Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        this.component.operate();
    }
}
