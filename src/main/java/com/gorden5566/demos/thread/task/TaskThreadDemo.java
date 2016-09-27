package com.gorden5566.demos.thread.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 打印[0, num)范围内的数字
 * Created by gorden5566 on 2016/8/14.
 */
public class TaskThreadDemo extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(TaskThreadDemo.class);
    private Long num;
    public TaskThreadDemo(Long num) {
        this.num = num;
    }

    @Override
    public void run() {
        // 执行具体操作
        execute();
    }

    private void execute() {
        for (int i = 0; i < num; i++) {
            logger.info("i = " + i);
        }
    }
}
