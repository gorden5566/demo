package com.gorden5566.demos.loadbalance;

import java.util.List;

/**
 * @author gorden5566
 * @date 2019/09/01
 */
public abstract class AbstractLoadBalance implements LoadBalance {
    @Override
    public Invoker select(List<Invoker> invokers) {
        if (invokers == null || invokers.isEmpty()) {
            return null;
        }

        if (invokers.size() == 1) {
            return invokers.get(0);
        }

        return doSelect(invokers);
    }

    /**
     * 选择合适的服务提供者
     *
     * @param invokers
     * @return
     */
    protected abstract Invoker doSelect(List<Invoker> invokers);

    /**
     * 获取权重
     *
     * @param invoker
     * @return
     */
    protected int getWeight(Invoker invoker) {
        return invoker.getWeight();
    }
}
