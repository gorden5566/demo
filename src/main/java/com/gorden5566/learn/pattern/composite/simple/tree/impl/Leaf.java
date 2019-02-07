package com.gorden5566.learn.pattern.composite.simple.tree.impl;

import com.gorden5566.learn.pattern.composite.simple.tree.ILeaf;

public class Leaf implements ILeaf {

    //叶子叫什么名字
    private String name;
    //叶子的职位
    private String position;
    //叶子的薪水
    private int salary;

    public Leaf(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        String info = "";
        info = "名称： " + this.name;
        info = info + "\t职位： " + this.position;
        info = info + "\t薪水： " + this.salary;
        return info;
    }
}
