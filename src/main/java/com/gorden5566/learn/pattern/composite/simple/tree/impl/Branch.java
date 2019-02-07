package com.gorden5566.learn.pattern.composite.simple.tree.impl;

import com.gorden5566.learn.pattern.composite.simple.tree.IBranch;
import com.gorden5566.learn.pattern.composite.simple.tree.ILeaf;

import java.util.ArrayList;
import java.util.List;

public class Branch implements IBranch {
    //存储子节点的信息
    private List subordinateList = new ArrayList();
    //树枝节点的名称
    private String name = "";
    //树枝节点的职位
    private String position = "";
    //树枝节点的薪水
    private int salary = 0;

    public Branch(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void add(IBranch branch) {
        this.subordinateList.add(branch);
    }

    public void add(ILeaf leaf) {
        this.subordinateList.add(leaf);
    }

    //获得自己树枝节点的信息
    public String getInfo() {
        String info = "";
        info = "名称： " + this.name;
        info = info + "\t职位： " + this.position;
        info = info + "\t薪水： " + this.salary;
        return info;
    }//获得下级的信息

    public List getSubordinateInfo() {
        return this.subordinateList;
    }
}
