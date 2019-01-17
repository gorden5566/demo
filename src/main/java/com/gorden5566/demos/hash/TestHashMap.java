package com.gorden5566.demos.hash;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gorden5566
 * @date 2018/12/25
 *
 * Hash 并发问题
 */
public class TestHashMap extends Thread {
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2);
    static AtomicInteger at = new AtomicInteger();

    @Override
    public void run() {
        while (at.get() < 1000000) {
            map.put(at.get(), at.get());
            at.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        TestHashMap t0 = new TestHashMap();
        TestHashMap t1 = new TestHashMap();
        TestHashMap t2 = new TestHashMap();
        TestHashMap t3 = new TestHashMap();
        TestHashMap t4 = new TestHashMap();
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
