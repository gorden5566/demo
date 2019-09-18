package com.gorden5566.demos.thread.future;

/**
 * @author gorden5566
 * @date 2019/09/19
 */
public interface Future<V> {

    /**
     * 是否完成
     *
     * @return
     */
    boolean isDone();

    /**
     * 获取结果
     *
     * @param timeoutMillis 超时时间
     * @return
     * @throws InterruptedException
     */
    V get(long timeoutMillis) throws InterruptedException;
}
