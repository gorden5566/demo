package com.gorden5566.learn.pattern.composite.simple.tree;

import java.util.List;

public interface IBranch {
    /**
     * 获得信息
     *
     * @return
     */
    String getInfo();

    /**
     * 增加数据节点， 例如研发部下设的研发一组
     *
     * @param branch
     */
    void add(IBranch branch);

    /**
     * 增加叶子节点
     *
     * @param leaf
     */
    void add(ILeaf leaf);

    /**
     * 获得下级信息
     *
     * @return
     */
    List getSubordinateInfo();
}
