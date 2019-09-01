package com.gorden5566.demos.loadbalance;

import java.util.List;
import java.util.Random;

/**
 * @author gorden5566
 * @date 2019/09/01
 */
public class SimpleRoundRobinLoadBalance extends AbstractLoadBalance {

    private Random random = new Random();

    private int index = 0;

    @Override
    protected Invoker doSelect(List<Invoker> invokers) {

        Invoker invoker = null;

        synchronized (this) {
            invoker = invokers.get(index);

            index++;
            if (index >= invokers.size()) {
                index = 0;
            }
        }

        if (invoker == null) {
            invoker = invokers.get(random.nextInt());
        }

        return invoker;
    }
}
