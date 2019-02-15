package com.gorden5566.learn.pattern.manual.decorator.demo.decorator;

import com.gorden5566.learn.pattern.manual.decorator.demo.component.Component;

public abstract class Decorator extends Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        this.component.operate();
    }
}
