package com.gorden5566.learn.pattern.iterator.simple;

import com.gorden5566.learn.pattern.iterator.simple.iterator.IProjectIterator;
import com.gorden5566.learn.pattern.iterator.simple.iterator.ProjectIterator;

import java.util.ArrayList;
import java.util.List;

public class Project implements IProject {

    //定义一个项目列表， 说有的项目都放在这里
    private List<IProject> projectList = new ArrayList<IProject>();

    //项目名称
    private String name = "";
    //项目成员数量
    private int num = 0;
    //项目费用
    private int cost = 0;

    public Project() {
    }

    private Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public void add(String name, int num, int cost) {
        this.projectList.add(new Project(name, num, cost));
    }

    @Override
    public String getProjectInfo() {
        String info = "";
        //获得项目的名称
        info = info + "项目名称是： " + this.name;
        //获得项目人数
        info = info + "\t项目人数: " + this.num;
        //项目费用
        info = info + "\t项目费用： " + this.cost;
        return info;
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
}
