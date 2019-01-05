package com.gorden5566.demos.thread.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author gorden5566
 * @date 2019/1/5
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        int threadNum = 7;
        ThreadPool threadPool = new DefaultThreadPool(threadNum);

        // 任务数量监控
        Monitor monitor = new Monitor(threadPool);
        monitor.start();

        // 任务数量
        int taskCount = 50;
        CountDownLatch end = new CountDownLatch(taskCount);

        // 任务大小
        int taskSize = 2;
        for (int i = 0; i < taskCount; i++) {
            Task task = new Task(taskSize, end);
            threadPool.execute(task);
        }

        // 等待任务执行完
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Job end!");

        // 关闭 monitor
        monitor.close();

        // 移除所有工作线程
        threadPool.removeWorker(threadNum);

        System.out.println("close");
    }

    /**
     * 模拟任务
     */
    static class Task implements Runnable {
        private int num;
        private CountDownLatch countDownLatch;

        public Task(int num, CountDownLatch countDownLatch) {
            this.num = num;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < num; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " complete count: " + (i + 1));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    /**
     * 监控器
     */
    static class Monitor extends Thread {
        private volatile boolean running = true;

        private final ThreadPool threadPool;

        public Monitor(ThreadPool threadPool) {
            this.threadPool = threadPool;
        }

        @Override
        public void run() {
            while (running) {
                System.out.println("left job size: " + threadPool.getJobSize());

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void close() {
            running = false;
        }
    }
}
