package com.gorden5566.thread.task;

import org.junit.Test;

/**
 * Created by gorden5566 on 2016/8/14.
 */
public class TaskDemoThreadTest {

    @Test
    public void test() {
        // 创建两个线程
        TaskDemoThread thread1 = new TaskDemoThread(100L);
        TaskDemoThread thread2 = new TaskDemoThread(100L);

        // 执行线程
        thread1.start();
        thread2.start();

        // 主线程等待1s后再结束
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
