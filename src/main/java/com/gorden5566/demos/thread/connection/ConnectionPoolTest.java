package com.gorden5566.demos.thread.connection;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gorden5566
 * @date 2019/1/5
 */
public class ConnectionPoolTest {
    /**
     * 线程池大小为 10
     */
    static ConnectionPool pool = new ConnectionPool(10);

    /**
     * 保证所有 ConnectionRunner 能够同时开始
     */
    static CountDownLatch start = new CountDownLatch(1);

    /**
     * main 线程将会等待所有 ConnectionRunner 结束后才能继续执行
     */
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 50;
        end = new CountDownLatch(threadCount);

        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread" + i);
            thread.start();
        }

        start.countDown();
        end.await();

        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            // 等待 main 线程通知，一起执行
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0) {
                try {
                    // 从线程池中获取连接，如果 1000ms 内无法获取到，将会返回 null
                    // 分别统计连接获取的数量 got 和未获取到的数量 notGot
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }

                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }

            // 全部执行完，main 线程再继续执行
            end.countDown();
        }
    }

}
