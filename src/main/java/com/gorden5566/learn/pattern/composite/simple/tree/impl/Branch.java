package com.gorden5566.learn.pattern.composite.simple.tree.impl;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Corp {
    //存储子节点的信息
    private List subordinateList = new ArrayList();

    public Branch(String name, String position, int salary) {
        super(name, position, salary);
    }

    public void addSubordinate(Corp corp) {
        this.subordinateList.add(corp);
    }

    public List<Corp> getSubordinate() {
        return this.subordinateList;
    }
}
