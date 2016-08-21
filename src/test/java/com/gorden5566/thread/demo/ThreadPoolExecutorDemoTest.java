package com.gorden5566.thread.demo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gorden5566 on 2016/8/14.
 */
public class ThreadPoolExecutorDemoTest {

    @Test
    public void test() {
        ThreadPoolExecutorDemo demo = new ThreadPoolExecutorDemo(10, 2, 100L);
        demo.doTask();
    }
}