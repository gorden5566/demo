package com.gorden5566.demos.thread.state;

/**
 * @author gorden5566
 * @date 2019-02-21
 */
public class StateRunnable implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new StateRunnable(), "myThread");

        thread.start();
    }

    @Override
    public void run() {
        showState();
    }

    /**
     *
     */
    public void showState() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": " + thread.getState());
    }
}
