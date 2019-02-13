package com.gorden5566.learn.pattern.bridge.simple.corp;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class IPodCorp extends Corp {
    @Override
    protected void produce() {
        System.out.println("我生产iPod...");
    }

    @Override
    protected void sell() {
        System.out.println("iPod畅销...");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱呀...");
    }
}
