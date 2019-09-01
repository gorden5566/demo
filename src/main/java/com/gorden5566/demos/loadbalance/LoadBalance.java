package com.gorden5566.demos.loadbalance;

import java.util.List;

/**
 * @author gorden5566
 * @date 2019/09/01
 */
public interface LoadBalance {

    /**
     * 从列表中选择合适的服务提供者
     *
     * @param invokers
     * @return
     */
    Invoker select(List<Invoker> invokers);
}
