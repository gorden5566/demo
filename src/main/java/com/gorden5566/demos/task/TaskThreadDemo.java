package com.gorden5566.demos.task;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * 打印[0, num)范围内的数字
 * Created by gorden5566 on 2016/8/14.
 */
public class TaskThreadDemo extends Thread {
    private static final Log logger = LogFactory.getLog(TaskThreadDemo.class);
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
