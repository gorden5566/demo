package com.gorden5566.demos.loadbalance;

import java.util.List;
import java.util.Random;

/**
 * @author gorden5566
 * @date 2019/09/02
 */
public class SimpleRandomLoadBalance extends AbstractLoadBalance {

    private Random random = new Random();

    @Override
    protected Invoker doSelect(List<Invoker> invokers) {
        int length = invokers.size();

        int index = random.nextInt(length);

        return invokers.get(index);
    }
}
