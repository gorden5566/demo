package com.gorden5566.learn.pattern.composite.simple.tree;

import java.util.List;

public interface IBranch extends ICorp {

    /**
     * 能够增加小兵（ 树叶节点） 或者是经理（ 树枝节点）
     *
     * @param corp
     */
    void addSubordinate(ICorp corp);

    /**
     * 我还要能够获得下属的信息
     *
     * @return
     */
    List<ICorp> getSubordinate();
}
