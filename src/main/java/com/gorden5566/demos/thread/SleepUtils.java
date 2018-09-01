package com.gorden5566.demos.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author gorden5566
 * @date 2018/9/1
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
