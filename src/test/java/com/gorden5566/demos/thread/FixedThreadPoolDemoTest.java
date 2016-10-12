package com.gorden5566.demos.thread;

import org.junit.Test;

/**
 * Created by gorden5566 on 2016/8/14.
 */
public class FixedThreadPoolDemoTest {
    @Test
    public void test() {
        long num = 10L;
        int jobNum = 2;

        // 创建线程并执行
        FixedThreadPoolDemo demo = new FixedThreadPoolDemo(jobNum, num);
        demo.doTask();
    }
}