package com.gorden5566.demos.thread;

/**
 * @author gorden5566
 * @date 2018/9/1
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                // 虚拟机已经退出，这里没有执行
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
