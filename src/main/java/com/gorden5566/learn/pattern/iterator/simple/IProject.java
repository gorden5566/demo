package com.gorden5566.learn.pattern.iterator.simple;

import com.gorden5566.learn.pattern.iterator.simple.iterator.IProjectIterator;

public interface IProject {

    /**
     * 增加项目
     *
     * @param name
     * @param num
     * @param cost
     */
    void add(String name,int num,int cost);

    /**
     * 从老板这里看到的就是项目信息
     *
     * @return
     */
    String getProjectInfo();

    /**
     * 获得一个可以被遍历的对象
     *
     * @return
     */
    IProjectIterator iterator();
}
