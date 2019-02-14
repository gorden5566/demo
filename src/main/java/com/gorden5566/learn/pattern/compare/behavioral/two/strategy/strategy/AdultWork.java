package com.gorden5566.learn.pattern.compare.behavioral.two.strategy.strategy;

import com.gorden5566.learn.pattern.compare.behavioral.two.strategy.WorkAlgorithm;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class AdultWork extends WorkAlgorithm {
    @Override
    public void work() {
        System.out.println("成年人的工作就是先养活自己，然后为社会做贡献！");
    }
}
