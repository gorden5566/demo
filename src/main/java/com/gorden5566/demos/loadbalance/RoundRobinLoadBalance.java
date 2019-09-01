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

    private ConcurrentMap<Invoker, Double> currWeightMap = new ConcurrentHashMap<>();
    private AtomicInteger sequence = new AtomicInteger();

    @Override
    protected Invoker doSelect(List<Invoker> invokers) {
        int length = invokers.size();
        double totalWeight = 0;
        double maxWeight = 0;
        double minWeight = Double.MAX_VALUE;
        Map<Invoker, Double> effectiveWeightMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Invoker invoker = invokers.get(i);
            double weight = getWeight(invoker);

            maxWeight = Math.max(maxWeight, weight);
            minWeight = Math.min(minWeight, weight);

            effectiveWeightMap.put(invoker, weight);
            totalWeight += weight;
        }

        // Integer.MIN_VALUE call getAndIncrement() will lead to Integer.MIN_VALUE
        // however it works well
        int currSequence = sequence.getAndIncrement();
        if (Double.compare(totalWeight, 0) == 0 || Double.compare(maxWeight, minWeight) == 0) {
            return invokers.get(currSequence % length);
        }

        double currMaxWeight = 0;
        int selectedIndex = 0;

        Invoker selectedInvoker;
        synchronized (currWeightMap) {
            for (int i = 0; i < length; i++) {
                Invoker invoker = invokers.get(i);

                Double currentWeight = currWeightMap.get(invoker);
                if (currentWeight == null) {
                    currWeightMap.putIfAbsent(invoker, 0.0);
                    currentWeight = currWeightMap.get(invoker);
                }

                Double effectiveWeight = effectiveWeightMap.get(invoker);
                if (Double.compare(effectiveWeight, 0) <= 0) {
                    continue;
                }

                currentWeight += effectiveWeight;
                currWeightMap.put(invoker, currentWeight);

                if (Double.compare(currentWeight, currMaxWeight) > 0) {
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
