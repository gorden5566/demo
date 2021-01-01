package com.gorden5566.demos.delay;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author gorden5566
 * @date 2021/01/01
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // do something
                System.out.println("timer task scheduled");
            }
        }, 1000, 1000); // 10s 后调度一个周期为 1s 的定时任务
    }
}
