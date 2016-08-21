package com.gorden5566.thread.demo;

import com.gorden5566.thread.task.TaskDemoThread;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * Created by gorden5566 on 2016/8/14.
 */
public class ThreadPoolExecutorDemo {
    private static final Log logger = LogFactory.getLog(ThreadPoolExecutorDemo.class);
    private long num;
    // 线程池大小
    private int maxThreadNum;
    // 队列大小
    private int queueSize;

    public ThreadPoolExecutorDemo(int maxThreadNum, int queueSize, long num) {
        this.maxThreadNum = maxThreadNum;
        this.queueSize = queueSize;
        this.num = num;
    }

    public void doTask() {
        int corePoolSize = maxThreadNum / 2;
        int maxPoolSize = maxThreadNum;
        long keepAliveTime = 1;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(queueSize);

        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
                    TimeUnit.MINUTES, workQueue, new ThreadPoolExecutor.AbortPolicy());

            // 创建线程并放入线程池执行
            for (int i = 0; i < maxThreadNum; i++) {
                executor.execute(new TaskDemoThread(num));
//                logger.info(executor.getQueue());
            }

            // 禁止在executor中添加新的任务
            executor.shutdown();

            // 等待线程池任务执行完毕
            while (true) {
                if (executor.isTerminated()) {
                    logger.info("线程池任务已执行完");
                    break;
                }
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
