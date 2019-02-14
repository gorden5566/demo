package com.gorden5566.learn.pattern.manual.iterator.demo.aggregate;

import com.gorden5566.learn.pattern.manual.iterator.demo.iterator.Iterator;

public interface Aggregate {
    /**
     * 是容器必然有元素的增加
     *
     * @param object
     */
    void add(Object object);

    /**
     * 减少元素
     *
     * @param object
     */
    void remove(Object object);

    /**
     * 由迭代器来遍历所有的元素
     *
     * @return
     */
    Iterator iterator();
}
