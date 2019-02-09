package com.gorden5566.learn.pattern.composite.demo.transparent.tree;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

    private List<Component> componentList = new ArrayList<>();

    @Override
    public void add(Component component) {
        componentList.add(component);
    }

    @Override
    public void remove(Component component) {
        componentList.add(component);
    }

    @Override
    public List<Component> getChildren() {
        return componentList;
    }
}
