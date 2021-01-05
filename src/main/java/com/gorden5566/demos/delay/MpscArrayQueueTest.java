package com.gorden5566.demos.delay;

import io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue;

/**
 * @author gorden5566
 * @date 2021/01/05
 */
public class MpscArrayQueueTest {
    public static final MpscArrayQueue<String> MPSC_ARRAY_QUEUE = new MpscArrayQueue<>(2);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            int index = i;
            new Thread(() -> MPSC_ARRAY_QUEUE.offer("data" + index), "thread" + index).start();
        }

        try {
            Thread.sleep(1000);
            MPSC_ARRAY_QUEUE.add("data3");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("队列大小：" + MPSC_ARRAY_QUEUE.size() + ", 队列容量：" + MPSC_ARRAY_QUEUE.capacity());
        System.out.println("出队：" + MPSC_ARRAY_QUEUE.remove()); // 出队操作，队列为空则抛出异常
        System.out.println("出队：" + MPSC_ARRAY_QUEUE.poll()); // 出队操作，队列为空则返回 NULL
    }
}
