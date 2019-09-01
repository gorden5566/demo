package com.gorden5566.demos.loadbalance;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author gorden5566
 * @date 2019/09/01
 */
public class LoadBalanceTest {
    private static final int INVOKE_COUNT = 100000;

    private List<Invoker> invokers;

    @Before
    public void init() {
        invokers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Invoker invoker = new Invoker();
            invoker.setAddress("192.168.0." + (i + 1));
            invoker.setWeight(i + 1);

            invokers.add(invoker);
        }
    }

    private void printInvokers() {
        Collections.sort(invokers, new Comparator<Invoker>() {
            @Override
            public int compare(Invoker o1, Invoker o2) {
                return o1.getInvokeNum() - o2.getInvokeNum();
            }
        });

        System.out.println();
        System.out.println("after call");
        System.out.println();

        for (Invoker invoker : invokers) {
            System.out.println(invoker);
        }
    }

    @Test
    public void testSimpleRandom() {
        LoadBalance loadBalance = new SimpleRandomLoadBalance();
        for (int i = 0; i < INVOKE_COUNT; i++) {
            Invoker select = loadBalance.select(invokers);
            select.invoke();
//            System.out.println(select);
        }

        printInvokers();
    }

    @Test
    public void testRandom() {
        LoadBalance loadBalance = new RandomLoadBalance();
        for (int i = 0; i < INVOKE_COUNT; i++) {
            Invoker select = loadBalance.select(invokers);
            select.invoke();
//            System.out.println(select);
        }

        printInvokers();
    }

    @Test
    public void testSimpleRoundRobin() {
        LoadBalance loadBalance = new SimpleRoundRobinLoadBalance();
        for (int i = 0; i < INVOKE_COUNT; i++) {
            Invoker select = loadBalance.select(invokers);
            select.invoke();
//            System.out.println(select);
        }

        printInvokers();
    }

    @Test
    public void testRoundRobin() {
        LoadBalance loadBalance = new RoundRobinLoadBalance();
        for (int i = 0; i < INVOKE_COUNT; i++) {
            Invoker select = loadBalance.select(invokers);
            select.invoke();
//            System.out.println(select);
        }

        printInvokers();
    }
}