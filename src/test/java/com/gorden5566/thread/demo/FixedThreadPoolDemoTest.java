package com.gorden5566.thread.demo;

import org.junit.Test;

/**
 * Created by gorden5566 on 2016/8/14.
 */
public class FixedThreadPoolDemoTest {
    @Test
    public void test() {
        FixedThreadPoolDemo demo = new FixedThreadPoolDemo(10, 100L);
        demo.doTask();
    }
}