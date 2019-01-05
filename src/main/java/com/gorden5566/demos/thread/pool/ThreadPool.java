package com.gorden5566.demos.thread.pool;

/**
 * @author gorden5566
 * @date 2019/1/5
 */
public interface ThreadPool<Job extends Runnable> {
    /**
     * 执行一个 Job，这个 Job 需要实现 Runnable
     *
     * @param job
     */
    void execute(Job job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     *
     * @param num
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     *
     * @param num
     */
    void removeWorker(int num);

    /**
     * 得到正在等待执行的任务数量
     *
     * @return
     */
    int getJobSize();
}
