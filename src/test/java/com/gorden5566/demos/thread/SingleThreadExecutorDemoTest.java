package com.gorden5566.demos.thread;

import org.junit.Test;

public class SingleThreadExecutorDemoTest {
    @Test
    public void test() {
        long num = 100L;
        int jobNum = 10;

        // 创建线程并执行
        SingleThreadExecutorDemo demo = new SingleThreadExecutorDemo(jobNum, num);
        demo.doTask();
    }
}