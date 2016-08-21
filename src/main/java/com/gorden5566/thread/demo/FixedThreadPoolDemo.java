package com.gorden5566.thread.demo;

import com.gorden5566.thread.task.TaskDemoThread;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程池
 * Created by gorden5566 on 2016/8/14.
 */
public class FixedThreadPoolDemo {
    private static final Log logger = LogFactory.getLog(FixedThreadPoolDemo.class);
    private long num;
    // 线程池大小
    private int maxThreadNum;

    public FixedThreadPoolDemo(int maxThreadNum, long num) {
        this.maxThreadNum = maxThreadNum;
        this.num = num;
    }

    public void doTask() {
        try {
            // 创建固定大小线程池
            ExecutorService executorService = Executors.newFixedThreadPool(maxThreadNum);

            // 创建线程并放入线程池执行
            for (int i = 0; i < maxThreadNum; i++) {
                executorService.execute(new TaskDemoThread(num));
            }

            // 禁止在exe中添加新的任务
            executorService.shutdown();

            // 等待线程池任务执行完毕
            while (true) {
                if (executorService.isTerminated()) {
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
