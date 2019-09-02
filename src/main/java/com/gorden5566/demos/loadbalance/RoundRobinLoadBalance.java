package com.gorden5566.demos.loadbalance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gorden5566
 * @date 2019/09/01
 */
public class RoundRobinLoadBalance extends AbstractLoadBalance {

    private ConcurrentMap<Invoker, Integer> currWeightMap = new ConcurrentHashMap<>();
    private AtomicInteger sequence = new AtomicInteger();

    @Override
    protected Invoker doSelect(List<Invoker> invokers) {
        int length = invokers.size();
        int totalWeight = 0;
        int maxWeight = 0;
        int minWeight = Integer.MAX_VALUE;
        Map<Invoker, Integer> effectiveWeightMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Invoker invoker = invokers.get(i);
            int weight = getWeight(invoker);

            maxWeight = Math.max(maxWeight, weight);
            minWeight = Math.min(minWeight, weight);

            effectiveWeightMap.put(invoker, weight);
            totalWeight += weight;
        }

        // Integer.MIN_VALUE call getAndIncrement() will lead to Integer.MIN_VALUE
        // however it works well
        int currSequence = sequence.getAndIncrement();
        if (totalWeight == 0 || maxWeight == minWeight) {
            return invokers.get(currSequence % length);
        }

        int currMaxWeight = 0;
        int selectedIndex = 0;

        Invoker selectedInvoker;
        synchronized (currWeightMap) {
            for (int i = 0; i < length; i++) {
                Invoker invoker = invokers.get(i);

                Integer currentWeight = currWeightMap.get(invoker);
                if (currentWeight == null) {
                    currWeightMap.putIfAbsent(invoker, 0);
                    currentWeight = currWeightMap.get(invoker);
                }

                Integer effectiveWeight = effectiveWeightMap.get(invoker);
                if (effectiveWeight <= 0) {
                    continue;
                }

                currentWeight += effectiveWeight;
                currWeightMap.put(invoker, currentWeight);

                if (currentWeight > currMaxWeight) {
                    currMaxWeight = currentWeight;
                    selectedIndex = i;
                }
            }

            selectedInvoker = invokers.get(selectedIndex);
            currWeightMap.put(selectedInvoker, currWeightMap.get(selectedInvoker) - totalWeight);
        }

        return selectedInvoker;
    }
}
