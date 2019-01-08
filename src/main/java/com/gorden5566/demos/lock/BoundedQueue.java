package com.gorden5566.demos.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gorden5566
 * @date 2019/1/8
 */
public class BoundedQueue<T> {
    private Object[] items;

    /**
     * 添加的下标，删除的下标和数组当前数量
     */
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size) {
        this.items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            // 等待队列不满时才可以添加
            while (count == items.length) {
                notFull.await();
            }

            // 添加元素
            items[addIndex] = t;

            // 索引循环
            if (++addIndex == items.length) {
                addIndex = 0;
            }

            ++count;

            // 通知队列不为空
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();

        try {
            // 等待队列不空时才可以移除
            while (count == 0) {
                notEmpty.wait();
            }

            Object x = items[removeIndex];

            // 索引循环
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }

            --count;

            // 通知队列不满
            notFull.signal();

            return (T) x;
        } finally {
            lock.unlock();
        }
    }
}
