package com.gorden5566.demos.loadbalance;

import java.util.List;
import java.util.Random;

/**
 * @author gorden5566
 * @date 2019/09/03
 */
public class GcdRoundRobinLoadBalance extends AbstractLoadBalance {

    private Random random = new Random();
    private int index = -1;
    private int currentWeight = 0;

    @Override
    protected Invoker doSelect(List<Invoker> invokers) {
        int index = roundRobin(invokers);

        if (index >= 0) {
            return invokers.get(index);
        }

        return invokers.get(random.nextInt(invokers.size()));
    }

    private int roundRobin(List<Invoker> invokers) {
        int length = invokers.size();
        int maxWeight = getWeight(invokers.get(0));


        int[] weights = new int[length];
        for (int i = 0; i < length; i++) {
            weights[i] = getWeight(invokers.get(i));
            if (weights[i] > maxWeight) {
                maxWeight = weights[i];
            }
        }

        int gcdWeights = gcdWeight(weights);

        while (true) {
            index = (index +1) % length;
            if (index == 0) {
                currentWeight = currentWeight - gcdWeights;
                if (currentWeight <= 0) {
                    currentWeight = maxWeight;
                    if (currentWeight == 0) {
                        return -1;
                    }
                }
            }

            if (weights[index] >= currentWeight) {
                return index;
            }
        }
    }

    /**
     * 计算最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }

    /**
     * 计算最大公约数
     *
     * @param data
     * @param length
     * @return
     */
    private int gcdN(int[] data, int length) {
        if (length == 1) {
            return data[0];
        }

        return gcd(data[length - 1], gcdN(data, length - 1));
    }

    /**
     * 计算所有权重的最大公约数
     *
     * @param weights
     * @return
     */
    private int gcdWeight(int[] weights) {
        return gcdN(weights, weights.length);
    }
}
