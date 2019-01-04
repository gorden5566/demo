package com.gorden5566.demos.thread;

/**
 * @author gorden5566
 * @date 2018/12/24
 */
public class DeadLockDemo {
    //定义锁对象
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    private void deadLock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB) {
                        System.out.println("Lock B");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB) {
                    synchronized (lockA) {
                        System.out.println("Lock A");
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
