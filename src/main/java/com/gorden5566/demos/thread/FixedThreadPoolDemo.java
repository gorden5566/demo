package com.gorden5566.demos.thread;

import com.gorden5566.demos.thread.task.TaskThreadDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程池
 * Created by gorden5566 on 2016/8/14.
 */
public class FixedThreadPoolDemo {
    private static final Logger logger = LoggerFactory.getLogger(FixedThreadPoolDemo.class);
    private long num;
    // 任务数量
    private int jobNum;

    public FixedThreadPoolDemo(int jobNum, long num) {
        this.jobNum = jobNum;
        this.num = num;
    }

    public void doTask() {
        try {
            // 创建大小为2的固定线程池
            ExecutorService executor = Executors.newFixedThreadPool(2);

            // 创建线程并放入线程池执行
            for (int i = 0; i < jobNum; i++) {
                TaskThreadDemo thread = new TaskThreadDemo(num);
                executor.execute(thread);
            }

            // 禁止在exe中添加新的任务
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
            logger.error(e.getMessage(), e);
        }
    }
}
