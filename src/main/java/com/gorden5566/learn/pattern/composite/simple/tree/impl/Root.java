package com.gorden5566.learn.pattern.composite.simple.tree.impl;

import com.gorden5566.learn.pattern.composite.simple.tree.IBranch;
import com.gorden5566.learn.pattern.composite.simple.tree.ILeaf;
import com.gorden5566.learn.pattern.composite.simple.tree.IRoot;

import java.util.ArrayList;
import java.util.List;

public class Root implements IRoot {
    //保存根节点下的树枝节点和树叶节点， Subordinate的意思是下级
    private List subordinateList = new ArrayList();
    //根节点的名称
    private String name = "";
    //根节点的职位
    private String position = "";
    //根节点的薪水
    private int salary = 0;

    public Root(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void add(IBranch branch) {
        this.subordinateList.add(branch);
    }

    @Override
    public void add(ILeaf leaf) {
        this.subordinateList.add(leaf);
    }

    @Override
    public String getInfo() {
        String info = "";
        info = "名称： " + this.name;

        info = info + "\t职位： " + this.position;
        info = info + "\t薪水： " + this.salary;
        return info;
    }

    @Override
    public List getSubordinateInfo() {
        return this.subordinateList;
    }
}
