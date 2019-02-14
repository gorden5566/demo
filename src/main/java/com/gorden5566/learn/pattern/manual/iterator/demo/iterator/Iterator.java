package com.gorden5566.learn.pattern.manual.iterator.demo.iterator;

public interface Iterator {

    /**
     * 遍历到下一个元素
     *
     * @return
     */
    Object next();

    /**
     * 是否已经遍历到尾部
     *
     * @return
     */
    boolean hasNext();

    /**
     * 删除当前指向的元素
     *
     * @return
     */
    boolean remove();
}
