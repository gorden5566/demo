package com.gorden5566.demos.lock;

import com.gorden5566.demos.thread.SleepUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gorden5566
 * @date 2019/1/8
 */
public class FairAndUnfairTest {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock nonFairLock = new ReentrantLock2(false);

    public static void main(String[] args) {
//        testLock(nonFairLock);
        testLock(fairLock);
    }

    private static void testLock(Lock lock) {
        int threadCount = 5;
        for (int i = 0; i < threadCount; i++) {
            new Job(lock).start();
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());

            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            int count = 2;
            for (int i = 0; i <count; i++) {
                lockAndPrint();
            }
        }

        private void lockAndPrint() {
            lock.lock();

            try {
                System.out.println("Lock by [" + Thread.currentThread().getId() + "], Waiting by [" + getQueuedThreads() + "]");
                SleepUtils.second(1);
            } finally {
                lock.unlock();
            }
        }

        private String getQueuedThreads() {
            Collection<Thread> threads = ((ReentrantLock2) lock).getQueuedThreads();
            StringBuilder sb = new StringBuilder();

            boolean isStart = true;
            for (Thread thread : threads) {
                if (isStart) {
                    sb.append(thread.getId());
                    isStart = false;
                } else {
                    sb.append(",").append(thread.getId());
                }
            }
            return sb.toString();
        }
    }
}
