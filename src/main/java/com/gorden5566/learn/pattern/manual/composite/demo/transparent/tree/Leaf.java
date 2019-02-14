package com.gorden5566.learn.pattern.manual.composite.demo.transparent.tree;

import java.util.List;

public class Leaf extends Component {

    @Override
    public void doSomething() {
        System.out.println("Leaf do something");
    }

    @Deprecated
    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public List<Component> getChildren() {
        throw new UnsupportedOperationException();
    }
}
