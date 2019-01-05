package com.gorden5566.demos.thread.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author gorden5566
 * @date 2019/1/5
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    /**
     * 线程池最大限制数
     */
    private static final int MAX_WORKER_NUMBERS = 10;

    /**
     * 线程池默认的数量
     */
    private static final int DEFAULT_WORKER_NUMBERS = 5;

    /**
     * 线程池最小的数量
     */
    private static final int MIN_WORKER_NUMBERS = 1;

    /**
     * 这是一个工作列表，将会向里面插入工作
     */
    private final LinkedList<Job> jobs = new LinkedList<>();

    /**
     * 工作者列表
     */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    /**
     * 工作者线程的数量
     */
    private int workerNum = DEFAULT_WORKER_NUMBERS;

    /**
     * 线程编号生成
     */
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        this.workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(workerNum);
    }

    /**
     * 初始化线程工作者
     *
     * @param num
     */
    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);

            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }
    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                // 添加一个任务，然后通知工作者
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            // 允许全部移除
            if (num > this.workerNum) {
                throw new IllegalArgumentException("beyond workNum");
            }

            // 按照给定的数量停止 Worker
            int count = 0;
            while (count < num) {
                System.out.println("workers num: " + workers.size());
                // 每次移除第一个
                Worker worker = workers.get(0);
                if (workers.remove(worker)) {
                    worker.shutdown();

                    // 通知线程关闭
                    jobs.notify();
                    count++;
                }
            }

            this.workerNum -= count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    /**
     * 工作者，负责消费任务
     */
    class Worker implements Runnable {
        /**
         * 是否工作
         */
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (running && jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 感知到外部对 WorkerThread 的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    // 取出一个 Job
                    if (!jobs.isEmpty()) {
                        job = jobs.removeFirst();
                    }
                }

                // 执行 Job
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        // 忽略 Job 执行中的 Exception
                    }
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }
}
