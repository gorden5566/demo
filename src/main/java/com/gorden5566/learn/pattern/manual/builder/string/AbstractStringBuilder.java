package com.gorden5566.learn.pattern.manual.builder.string;

import java.util.Arrays;

/**
 * @author gorden5566
 * @date 2019-02-18
 */
public abstract class AbstractStringBuilder {
    protected char[] value;
    protected int count;

    public AbstractStringBuilder(int capacity) {
        value = new char[capacity];
        count = 0;
    }

    public AbstractStringBuilder append(char c) {
        // 确保数组容量足够
        ensureCapacityInternal(count + 1);

        value[count++] = c;
        return this;
    }

    private void ensureCapacityInternal(int miniCapacity) {
        // 需要扩容了
        if (miniCapacity > value.length) {
            expandCapacity(miniCapacity);
        }
    }

    /**
     * 根据所需的最小容量扩容，若扩两倍还不够则使用 miniCapacity
     *
     * @param miniCapacity
     */
    private void expandCapacity(int miniCapacity) {
        int newCapacity = value.length * 2;
        if (newCapacity < miniCapacity) {
            newCapacity = miniCapacity;
        }

        System.out.println("扩容后大小为： " + newCapacity);
        value = Arrays.copyOf(value, newCapacity);
    }
}
