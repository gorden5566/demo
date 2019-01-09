package com.gorden5566.demos.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author gorden5566
 * @date 2019/1/9
 */
public class CyclicBarrierTest2 {

    /**
     * 所有线程到达屏障后，优先执行 barrierAction
     */
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println(1);
            }
        }).start();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(2);
    }

    private static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
