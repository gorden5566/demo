package com.gorden5566.demos.pattern.proxy.simple;

/**
 * @author gorden5566
 * @date 2018/12/25
 */
public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("do queryCount");
    }

    @Override
    public void updateCount() {
        System.out.println("do updateCount");
    }
}
