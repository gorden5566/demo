package com.gorden5566.demos.thread;

import com.gorden5566.demos.task.TaskThreadDemo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    private static final Log logger = LogFactory.getLog(SingleThreadExecutorDemo.class);
    private long num;
    // 任务数量
    private int jobNum;

    public SingleThreadExecutorDemo(int jobNum, long num) {
        this.jobNum = jobNum;
        this.num = num;
    }

    public void doTask() {
        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();

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
