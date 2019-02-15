package com.gorden5566.learn.pattern.compare.cross.two.facade;

import java.util.Random;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Performance {
    /**
     * 基本工资
     */
    private BasicSalary salary = new BasicSalary();

    /**
     * 绩效奖励
     * @return
     */
    public int getPerformanceValue() {
        //随机绩效
        int perf = (new Random()).nextInt(100);
        return salary.getBasicSalary() * perf / 100;
    }
}
