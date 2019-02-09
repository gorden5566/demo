package com.gorden5566.learn.pattern.composite.demo.transparent.tree;

import java.util.List;

public abstract class Component {
    public void doSomething() {
        System.out.println("Component do something");
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract List<Component> getChildren();
}
