package com.gorden5566.demos.thread.state;

/**
 * @author gorden5566
 * @date 2019-02-21
 */
public class StateTimeWaiting implements Runnable {
    private Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StateTimeWaiting(), "myThread");
        thread.start();

        // 主线程等待
        thread.join(1000 * 60);
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                // 线程等待唤醒
                object.wait(1000 * 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
