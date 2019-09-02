package com.gorden5566.demos.loadbalance;

import java.util.List;
import java.util.Random;

/**
 * @author gorden5566
 * @date 2019/09/01
 */
public class RandomLoadBalance extends AbstractLoadBalance {

    private Random random = new Random();

    @Override
    protected Invoker doSelect(List<Invoker> invokers) {
        int length = invokers.size();

        int totalWeight = 0;
        int[] sumWeightArray = new int[length];

        for (int index = 0; index < length; index++) {
            int weight = getWeight(invokers.get(index));
            totalWeight += weight;

            sumWeightArray[index] = totalWeight;
        }

        int index = getIndex(sumWeightArray, totalWeight);

        return invokers.get(index);
    }

    /**
     * 根据权重随机选择一个下标
     *
     * @param sumWeightArray 权重求和数组
     * @param totalWeight 总权重
     * @return
     */
    private int getIndex(int[] sumWeightArray, int totalWeight) {
        int length = sumWeightArray.length;
        int offset = random.nextInt(totalWeight);

        for (int index = 0; index < length; index++) {
            if (sumWeightArray[index] > offset) {
                return index;
            }
        }

        return random.nextInt(length);
    }
}
