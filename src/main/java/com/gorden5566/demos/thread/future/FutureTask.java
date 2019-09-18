package com.gorden5566.demos.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gorden5566
 * @date 2019/09/19
 */
public class FutureTask<V> implements Future<V>, Runnable  {

    /**
     * 任务是否已完成
     */
    private volatile boolean done = false;

    /**
     * 计算结果
     */
    private Object outcome;

    /**
     * 线程同步
     */
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    /**
     * 实际要执行的任务
     */
    private Callable<V> callable;

    public FutureTask(Callable<V> callable) {
        this.callable = callable;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public V get(long timeoutMillis) throws InterruptedException {

        // 等待任务执行完
        awaitDone(timeoutMillis);

        return (V) outcome;
    }

    /**
     * 等待任务完成
     *
     * @param timeoutMillis
     * @throws InterruptedException
     */
    private void awaitDone(long timeoutMillis) throws InterruptedException {
        lock.lock();
        try {
            long leftTime = timeoutMillis;
            long deadline = System.currentTimeMillis() + timeoutMillis;

            while (true) {
                // 任务已完成 或 剩余时间小于0
                if (isDone() || leftTime <= 0) {
                    break;
                }

                // 继续等待
                condition.await(leftTime, TimeUnit.MILLISECONDS);

                // 计算剩余时间
                leftTime = deadline - System.currentTimeMillis();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        V result = null;

        // 执行任务
        if (callable != null) {
            try {
                result = callable.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        // 通知任务已完成
        lock.lock();
        try {
            this.outcome = result;
            this.done = true;

            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
