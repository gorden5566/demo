package com.gorden5566.demos.thread.task;

import org.junit.Test;

/**
 * Created by gorden5566 on 2016/8/14.
 */
public class TaskDemoThreadTest {

    @Test
    public void test() {
        long num = 100L;
        int jobNum = 10;

        // 创建10个任务线程并执行
        for (int i = 0; i < jobNum; i++) {
            TaskThreadDemo thread = new TaskThreadDemo(num);
            thread.start();
        }

        // 主线程等待1s后再结束
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
