package com.gorden5566.learn.pattern.compare.behavioral.two.strategy.strategy;

import com.gorden5566.learn.pattern.compare.behavioral.two.strategy.WorkAlgorithm;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class ChildWork extends WorkAlgorithm {
    @Override
    public void work() {
        System.out.println("儿童的工作是玩耍！");
    }
}
