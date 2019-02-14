package com.gorden5566.learn.pattern.manual.iterator.simple.iterator;

import com.gorden5566.learn.pattern.manual.iterator.simple.IProject;

import java.util.List;

public class ProjectIterator implements IProjectIterator {

    // 所有的项目都放在ArrayList中
    private List<IProject> projectList;

    // 当前位置
    private int currentItem = 0;

    public ProjectIterator(List<IProject> projectList) {
        this.projectList = projectList;
    }

    @Override
    public boolean hasNext() {
        //定义一个返回值
        boolean b = true;
        if (this.currentItem >= projectList.size() || this.projectList.get(this.currentItem) == null) {
            b = false;

        }
        return b;
    }

    @Override
    public Object next() {
        return this.projectList.get(this.currentItem++);
    }

    @Override
    public void remove() {

    }
}
