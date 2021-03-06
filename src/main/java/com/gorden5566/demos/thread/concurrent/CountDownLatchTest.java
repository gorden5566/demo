package com.gorden5566.demos.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author gorden5566
 * @date 2019/1/9
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                countDownLatch.countDown();
                System.out.println(2);
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();
        System.out.println(3);
    }
}
