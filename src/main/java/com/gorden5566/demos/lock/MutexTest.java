package com.gorden5566.demos.lock;

import com.gorden5566.demos.thread.SleepUtils;

import java.util.concurrent.locks.Lock;

/**
 * @author gorden5566
 * @date 2019/1/8
 */
public class MutexTest {
    private static final Lock lock = new Mutex();
//    private static final Lock lock = new TwinsLock();

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new Worker());
            thread.start();
        }

        Thread.sleep(threadCount * 1000);
    }

    private static class Worker implements Runnable {
        @Override
        public void run() {
            lock.lock();

            try {
                SleepUtils.second(1);
                System.out.println(Thread.currentThread());
                SleepUtils.second(1);
            } finally {
                lock.unlock();
            }
        }
    }
}
